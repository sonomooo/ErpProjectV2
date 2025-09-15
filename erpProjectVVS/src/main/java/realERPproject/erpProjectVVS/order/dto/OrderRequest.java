package realERPproject.erpProjectVVS.order.dto;

import lombok.Getter;
import realERPproject.erpProjectVVS.order.entity.OrderStatus;
import realERPproject.erpProjectVVS.user.entity.User;

@Getter
public class OrderRequest {

    Long user_id;
    String orderNumber;
    User customer;
    int orderQuantity;
    Long productId;

}
