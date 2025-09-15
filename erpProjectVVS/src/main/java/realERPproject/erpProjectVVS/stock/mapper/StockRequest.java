package realERPproject.erpProjectVVS.stock.mapper;

import lombok.Getter;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.user.entity.User;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

public record StockRequest(
        Product product,
        WareHouse warehouse,
        Order order,
        User assignee,
        int quantity
) {
}
