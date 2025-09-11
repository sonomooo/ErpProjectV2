package realERPproject.erpProjectVVS.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.product.dto.request.ProductRequest;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;
import realERPproject.erpProjectVVS.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestParam ProductRequest productRequest){

        ProductResponse product = productService.createProduct(productRequest);

        return ApiResponse.created(product, "상품을 생성하였습니다. ");
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ApiResponse<ProductResponse>> findProduct(@PathVariable Long productId){

        ProductResponse productById = productService.findProductById(productId);

        return ApiResponse.success(productById,"상품을 조회했습니다");
    }

}
