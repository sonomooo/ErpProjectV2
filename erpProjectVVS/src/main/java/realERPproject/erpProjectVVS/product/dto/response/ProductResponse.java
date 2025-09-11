package realERPproject.erpProjectVVS.product.dto.response;

import lombok.Builder;

@Builder
public class ProductResponse {

    private String code;
    private String category;
    private String brand;
    private String stockQuantity;
    private String location;
    private String price;
    private String description;

    public ProductResponse(String brand, String category, String code, String description, String location, String price, String stockQuantity) {
        this.brand = brand;
        this.category = category;
        this.code = code;
        this.description = description;
        this.location = location;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
