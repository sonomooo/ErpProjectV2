package realERPproject.erpProjectVVS.stock.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;
import realERPproject.erpProjectVVS.order.entity.Order;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.user.entity.User;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

@Getter
@Entity
@Builder
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private WareHouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignee;

    private int quantity;

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public void decrease(int amount) {
        if (quantity < amount) {
            throw new IllegalStateException("재고 부족");
        }
        this.quantity -= amount;
    }

}
