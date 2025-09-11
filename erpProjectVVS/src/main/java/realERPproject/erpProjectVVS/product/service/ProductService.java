package realERPproject.erpProjectVVS.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import realERPproject.erpProjectVVS.common.exception.ProductErrorCode;
import realERPproject.erpProjectVVS.product.dto.request.ProductRequest;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.product.exception.ProductException;
import realERPproject.erpProjectVVS.product.mapper.ProductMapper;
import realERPproject.erpProjectVVS.product.repository.ProductRepositoryImpl;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepositoryImpl productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){

        Product product = productMapper.toEntity(productRequest);

        productRepository.save(product);

        return productMapper.toResponse(productRequest);
    }

    public ProductResponse findProductById(Long productId){

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND));

        return productMapper.toResponseByProduct(product);
    }
}
