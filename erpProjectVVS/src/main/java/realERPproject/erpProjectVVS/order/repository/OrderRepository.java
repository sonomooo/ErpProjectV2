package realERPproject.erpProjectVVS.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realERPproject.erpProjectVVS.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
