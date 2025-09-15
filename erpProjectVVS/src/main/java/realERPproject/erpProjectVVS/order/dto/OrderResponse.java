package realERPproject.erpProjectVVS.order.dto;

import lombok.Builder;
import realERPproject.erpProjectVVS.order.entity.OrderStatus;
import realERPproject.erpProjectVVS.user.entity.User;

@Builder
public class OrderResponse {

    String orderNumber;
    OrderStatus orderStatus;
    User customer;
    int orderQuantity;

}
