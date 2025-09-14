package realERPproject.erpProjectVVS.product.dto.response;

import lombok.Builder;

@Builder
public class ProductResponse {

    private String productName;
    private String code;
    private String category;
    private String brand;
    private String price;
    private String description;

    public ProductResponse(String brand, String category, String code, String description, String price, String productName) {
        this.brand = brand;
        this.category = category;
        this.code = code;
        this.description = description;
        this.price = price;
        this.productName = productName;
    }
}
