package realERPproject.erpProjectVVS.product.dto.response;

import lombok.Builder;

@Builder
public record ProductResponse (
        String productName,
        String code,
        String category,
        String brand,
        String price,
        String description
){}
