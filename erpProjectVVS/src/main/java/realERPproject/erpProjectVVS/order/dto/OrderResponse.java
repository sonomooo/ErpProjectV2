package realERPproject.erpProjectVVS.order.dto;

import lombok.Builder;
import realERPproject.erpProjectVVS.order.entity.OrderStatus;
import realERPproject.erpProjectVVS.user.entity.User;

@Builder
public class OrderResponse {

    Long user_id;
    String orderNumber;
    OrderStatus orderStatus;
    User assignee;

}
