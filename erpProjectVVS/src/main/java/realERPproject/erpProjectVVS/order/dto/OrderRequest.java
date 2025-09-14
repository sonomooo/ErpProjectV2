package realERPproject.erpProjectVVS.order.dto;

import lombok.Getter;
import realERPproject.erpProjectVVS.order.entity.OrderStatus;
import realERPproject.erpProjectVVS.user.entity.User;

@Getter
public class OrderRequest {

    Long user_id;
    User user;
    String orderNumber;
    OrderStatus orderStatus;
    User assignee;

}
