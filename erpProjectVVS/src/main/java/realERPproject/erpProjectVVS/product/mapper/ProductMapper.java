package realERPproject.erpProjectVVS.product.mapper;

import realERPproject.erpProjectVVS.product.dto.request.ProductRequest;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;
import realERPproject.erpProjectVVS.product.entity.Product;

public class ProductMapper {

    public Product toEntity(ProductRequest productRequest){

        return Product.builder()
                .code(productRequest.getCode())
                .category(productRequest.getCategory())
                .brand(productRequest.getBrand())
                .stockQuantity(productRequest.getStockQuantity())
                .location(productRequest.getLocation())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
    }

    public ProductResponse toResponse(ProductRequest productRequest){

        return ProductResponse.builder()
                .brand(productRequest.getBrand())
                .category(productRequest.getCategory())
                .code(productRequest.getCode())
                .description(productRequest.getDescription())
                .location(productRequest.getLocation())
                .price(productRequest.getPrice())
                .stockQuantity(productRequest.getStockQuantity())
                .build();
    }

    public ProductResponse toResponseByProduct(Product product){

        return ProductResponse.builder()
                .brand(product.getBrand())
                .category(product.getCategory())
                .code(product.getCode())
                .description(product.getDescription())
                .location(product.getLocation())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .build();
    }

}
