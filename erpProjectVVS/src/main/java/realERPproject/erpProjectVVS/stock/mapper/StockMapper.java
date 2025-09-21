package realERPproject.erpProjectVVS.stock.mapper;

import org.springframework.stereotype.Component;
import realERPproject.erpProjectVVS.stock.entity.Stock;

@Component
public class StockMapper {

    public Stock toEntity(StockRequest stockRequest){

        return Stock.builder()
                .product(stockRequest.product())
                .warehouse(stockRequest.warehouse())
                .order(stockRequest.order())
                .assignee(stockRequest.assignee())
                .quantity(stockRequest.quantity())
                .build();
    }

    public StockResponse toResponse(Stock stock){

        return StockResponse.builder()
                .product(stock.getProduct())
                .warehouse(stock.getWarehouse())
                .order(stock.getOrder())
                .assignee(stock.getAssignee())
                .quantity(stock.getQuantity())
                .build();
    }
}
