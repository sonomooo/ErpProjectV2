package realERPproject.erpProjectVVS.order.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.service.OrderService;

@RequestMapping("/order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<OrderResponse>> order(OrderRequest orderRequest){

        OrderResponse order = orderService.createOrder(orderRequest);

        return ApiResponse.created(order,"주문이 완료되었습니다.");
    }

}
