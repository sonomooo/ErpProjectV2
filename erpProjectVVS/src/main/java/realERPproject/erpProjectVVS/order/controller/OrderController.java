package realERPproject.erpProjectVVS.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realERPproject.erpProjectVVS.common.response.ApiPageResponse;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.dto.OrderSearchCondition;
import realERPproject.erpProjectVVS.order.service.OrderService;

@RequestMapping("/order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(OrderRequest orderRequest){

        OrderResponse order = orderService.createOrder(orderRequest);

        return ApiResponse.created(order,"주문이 완료되었습니다.");
    }

    @GetMapping
    public ResponseEntity<ApiPageResponse<OrderResponse>> getOrders(@RequestParam(required = false,defaultValue = "0") int page,
                                                                @RequestParam(required = false,defaultValue = "0") int size,
                                                                @RequestParam String keyWord
    ){
        Page<OrderResponse> listByOrderPage = orderService.findListByOrderPage(keyWord, size, page);

        return ApiPageResponse.success(listByOrderPage,"주문 리스트를 불러왔습니다.");
    }

}
