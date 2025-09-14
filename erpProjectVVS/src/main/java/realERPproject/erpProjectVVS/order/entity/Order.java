package realERPproject.erpProjectVVS.order.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;
import realERPproject.erpProjectVVS.user.entity.User;

@Entity
@Table(name = "orders")
@Builder
@Getter
public class Order extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String orderNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    protected Order() {}  // 추가


}
