package realERPproject.erpProjectVVS.stock.mapper;

import lombok.Builder;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.user.entity.User;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

@Builder
public record StockResponse(
        Product product,
        WareHouse warehouse,
        Order order,
        User assignee,
        int quantity
) {
}
