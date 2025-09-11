package realERPproject.erpProjectVVS.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;

@Entity
@Getter
public class Product extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String code;
    private final String category;
    private final String brand;
    private final String price;
    private final String description;

    @Builder
    public Product(String brand, String category, String code, String description, String price) {
        this.brand = brand;
        this.category = category;
        this.code = code;
        this.description = description;
        this.price = price;
    }
}
