package realERPproject.erpProjectVVS.order.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.entity.Order;

@Component
public class OrderMapper {

    public OrderResponse toResponse(OrderRequest orderRequest){

        return OrderResponse.builder()
                .user_id(orderRequest.getUser_id())
                .orderNumber(orderRequest.getOrderNumber())
                .orderStatus(orderRequest.getOrderStatus())
                .assignee(orderRequest.getAssignee())
                .build();
    }

    public Page<OrderResponse> toResponsePage(Page<Order> orderPage){

        return orderPage.map(order ->
                OrderResponse.builder()
                        .user_id(order.getUser().getId())
                        .orderNumber(order.getOrderNumber())
                        .orderStatus(order.getOrderStatus())
                        .assignee(order.getAssignee())
                        .build());
    }

    public Order toEntity(OrderRequest orderRequest){

        return Order.builder()
                .user(orderRequest.getUser())
                .orderNumber(orderRequest.getOrderNumber())
                .orderStatus(orderRequest.getOrderStatus())
                .assignee(orderRequest.getAssignee())
                .build();
    }
}
