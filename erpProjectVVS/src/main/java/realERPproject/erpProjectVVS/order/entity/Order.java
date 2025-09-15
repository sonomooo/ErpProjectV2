package realERPproject.erpProjectVVS.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;
import realERPproject.erpProjectVVS.order.dto.OrderRequest;
import realERPproject.erpProjectVVS.order.mapper.OrderMapper;
import realERPproject.erpProjectVVS.stock.entity.Stock;
import realERPproject.erpProjectVVS.user.entity.User;

@Entity
@Table(name = "orders")
@Getter
public class Order extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User customer;

    private String orderNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    protected Order() {}  // 추가

    public static Order create(OrderRequest request,Stock stock){

        stock.decrease(request.getOrderQuantity());

        return new OrderMapper().toEntity(request);
    }

    @Builder
    public Order(User customer, String orderNumber, OrderStatus orderStatus, Long productId) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.productId = productId;
    }
}
