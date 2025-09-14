package realERPproject.erpProjectVVS.order.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.dto.OrderSearchCondition;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.order.mapper.OrderMapper;
import realERPproject.erpProjectVVS.order.repository.OrderRepository;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest orderRequest){

        orderRepository.save(orderRequest);

        return orderMapper.toResponse(orderRequest);
    }

    public Page<OrderResponse> findListByOrderPage(String keyWord,
                                                   int page,
                                                   int size
    ){
        PageRequest pageRequest = PageRequest.of(page,size);

        Page<Order> byOrderNameContaining = orderRepository.findByOrderByOrderId(keyWord,pageRequest);

        return orderMapper.toResponsePage(byOrderNameContaining);
    }


}
