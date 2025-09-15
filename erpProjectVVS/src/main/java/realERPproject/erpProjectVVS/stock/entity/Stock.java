package realERPproject.erpProjectVVS.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;
import realERPproject.erpProjectVVS.user.entity.User;

@Getter
@Entity
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue
    Long Id;

    Long WareHouse_Id;

    Long Order_Id;

    Long user_Id;

    Long Product_Id;

    User assignee;

    int quantity;

    String location;

    public void decrease(int amount){
        if (quantity < amount){
            throw new IllegalStateException("재고 부족");
        }
        this.quantity -= amount;
    }

}
