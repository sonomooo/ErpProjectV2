package realERPproject.erpProjectVVS.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import realERPproject.erpProjectVVS.common.exception.GlobalException;
import realERPproject.erpProjectVVS.common.exception.ProductErrorCode;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.product.exception.ProductException;
import realERPproject.erpProjectVVS.product.repository.ProductRepositoryImpl;
import realERPproject.erpProjectVVS.stock.entity.Stock;
import realERPproject.erpProjectVVS.stock.mapper.StockMapper;
import realERPproject.erpProjectVVS.stock.mapper.StockRequest;
import realERPproject.erpProjectVVS.stock.mapper.StockResponse;
import realERPproject.erpProjectVVS.stock.stockRepository.StockRepositoryImpl;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepositoryImpl stockRepository;
    private final StockMapper stockMapper;
    private final WareHouse wareHouse;
    private final ProductRepositoryImpl productRepository;

    @Transactional
    public StockResponse getWareHousing(StockRequest stockRequest){

        Product product = productRepository.findById(stockRequest.product().getId())
                .orElseThrow(()-> new GlobalException(ProductErrorCode.PRODUCT_NOT_FOUND));

        Stock entity = stockMapper.toEntity(stockRequest);

        entity.addQuantity(stockRequest.quantity());
        wareHouse.increaseStock(product, stockRequest.quantity());

        stockRepository.save(entity);

        return stockMapper.toResponse(entity);
    }

}
