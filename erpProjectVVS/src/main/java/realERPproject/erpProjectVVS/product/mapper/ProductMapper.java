package realERPproject.erpProjectVVS.product.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import realERPproject.erpProjectVVS.product.dto.request.ProductRequest;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;
import realERPproject.erpProjectVVS.product.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest productRequest){

        return Product.builder()
                .productName(productRequest.getProductName())
                .code(productRequest.getCode())
                .category(productRequest.getCategory())
                .brand(productRequest.getBrand())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
    }

    public ProductResponse toResponse(ProductRequest productRequest){

        return ProductResponse.builder()
                .productName(productRequest.getProductName())
                .brand(productRequest.getBrand())
                .category(productRequest.getCategory())
                .code(productRequest.getCode())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    public ProductResponse toResponseByProduct(Product product){

        return ProductResponse.builder()
                .productName(product.getProductName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .code(product.getCode())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Page<ProductResponse> toProductResponseByProductPage(Page<Product> productPage) {

        return productPage.map(product ->
                ProductResponse.builder()
                        .productName(product.getProductName())
                        .code(product.getCode())
                        .category(product.getCategory())
                        .brand(product.getBrand())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .build());
    }

}
