package realERPproject.erpProjectVVS.order.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import realERPproject.erpProjectVVS.common.exception.GlobalException;
import realERPproject.erpProjectVVS.common.exception.ProductErrorCode;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.dto.OrderSearchCondition;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.order.mapper.OrderMapper;
import realERPproject.erpProjectVVS.order.repository.OrderRepository;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.product.exception.ProductException;
import realERPproject.erpProjectVVS.product.repository.ProductRepositoryImpl;
import realERPproject.erpProjectVVS.stock.entity.Stock;
import realERPproject.erpProjectVVS.stock.stockRepository.StockRepositoryImpl;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepositoryImpl productRepository;
    private final StockRepositoryImpl stockRepository;
    private final WareHouse wareHouse;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest){

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new GlobalException(ProductErrorCode.PRODUCT_NOT_FOUND));
        Stock productQuantity = stockRepository.findQuantityById(product.getId());

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

        Page<Order> byOrderNameContaining = orderRepository.findByOrderByOrderId(keyWord,pageRequest);

        return orderMapper.toResponsePage(byOrderNameContaining);
    }

}
