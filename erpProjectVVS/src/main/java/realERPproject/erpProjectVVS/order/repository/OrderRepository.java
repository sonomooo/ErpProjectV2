package realERPproject.erpProjectVVS.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.dto.OrderResponse;
import realERPproject.erpProjectVVS.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    void save(OrderRequest orderRequest);

    Page<Order> findAll(Pageable pageble);

    Page<Order>  findByOrderById(String keyWord,Pageable pageable);
}
