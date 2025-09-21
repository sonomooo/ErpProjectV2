package realERPproject.erpProjectVVS.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import realERPproject.erpProjectVVS.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String productName;
    String code;
    String category;
    String brand;
    String price;
    String description;

    @Builder
    public Product(String productName,String brand, String category, String code, String description, String price) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.code = code;
        this.description = description;
        this.price = price;
    }
}
