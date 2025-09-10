package realERPproject.erpProjectVVS.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;

@Builder
@Entity
@Getter
public class Product extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String category;
    private String brand;
    private int stockQuantity;
    private String location;
    private String price;
    private String description;

    public Product(String brand, String category, String code, String description, String location, String price, int stockQuantity) {
        this.brand = brand;
        this.category = category;
        this.code = code;
        this.description = description;
        this.location = location;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
