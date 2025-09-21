package realERPproject.erpProjectVVS.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import realERPproject.erpProjectVVS.common.exception.GlobalException;
import realERPproject.erpProjectVVS.common.exception.ProductErrorCode;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.order.mapper.OrderMapper;
import realERPproject.erpProjectVVS.order.repository.OrderRepository;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.product.repository.ProductRepositoryImpl;
import realERPproject.erpProjectVVS.stock.entity.Stock;
import realERPproject.erpProjectVVS.stock.stockRepository.StockRepositoryImpl;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;
import realERPproject.erpProjectVVS.wareHouse.exception.WareHouseErrorCode;
import realERPproject.erpProjectVVS.wareHouse.exception.WareHouseException;
import realERPproject.erpProjectVVS.wareHouse.repository.WareHouseRepositoryImpl;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepositoryImpl productRepository;
    private final StockRepositoryImpl stockRepository;
    private final WareHouseRepositoryImpl wareHouseRepository;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest){

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new GlobalException(ProductErrorCode.PRODUCT_NOT_FOUND));
        Stock productQuantity = stockRepository.findQuantityById(product.getId());

        WareHouse wareHouse = wareHouseRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new GlobalException(WareHouseErrorCode.WARE_HOUSE_ERROR_CODE));

        Order entity = Order.create(orderRequest, productQuantity);
        wareHouse.decreaseStock(product,orderRequest.getOrderQuantity());

        orderRepository.save(entity);

        return orderMapper.toResponse(entity);
    }

    public Page<OrderResponse> findListByOrderPage(String keyWord,
                                                   int page,
                                                   int size
    ){
        PageRequest pageRequest = PageRequest.of(page,size);

        Page<Order> byOrderNameContaining = orderRepository.findByOrderById(keyWord,pageRequest);

        return orderMapper.toResponsePage(byOrderNameContaining);
    }

}
