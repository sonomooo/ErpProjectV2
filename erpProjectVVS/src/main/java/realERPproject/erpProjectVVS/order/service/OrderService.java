package realERPproject.erpProjectVVS.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderRequest orderRequest){

        orderRepository.save(orderRequest);

        return OrderResponse
    }
}
