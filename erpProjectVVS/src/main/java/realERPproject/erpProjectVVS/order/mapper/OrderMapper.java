package realERPproject.erpProjectVVS.order.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.order.entity.OrderStatus;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order){

        return OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .customer(order.getCustomer())
                .build();
    }

    public Page<OrderResponse> toResponsePage(Page<Order> orderPage){

        return orderPage.map(order ->
                OrderResponse.builder()
                        .orderNumber(order.getOrderNumber())
                        .orderStatus(order.getOrderStatus())
                        .customer(order.getCustomer())
                        .build());
    }

    public Order toEntity(OrderRequest orderRequest){

        return Order.builder()
                .customer(orderRequest.getCustomer())
                .orderNumber(orderRequest.getOrderNumber())
                .orderStatus(OrderStatus.CREATED)
                .productId(orderRequest.getProductId())
                .build();
    }
}
