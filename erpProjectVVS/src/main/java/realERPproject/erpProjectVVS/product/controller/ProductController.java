package realERPproject.erpProjectVVS.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realERPproject.erpProjectVVS.common.response.ApiPageResponse;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.product.dto.request.ProductRequest;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;
import realERPproject.erpProjectVVS.product.service.ProductService;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest
    ){

        ProductResponse product = productService.createProduct(productRequest);

        return ApiResponse.created(product, "상품을 생성하였습니다. ");
    }

    @GetMapping("/find/{taskId}")
    public ResponseEntity<ApiResponse<ProductResponse>> findProduct(@PathVariable("taskId") Long productId){

        ProductResponse productById = productService.findProductById(productId);

        return ApiResponse.success(productById,"상품을 조회했습니다");
    }

    @GetMapping("/findList/{keyword}")
    public ResponseEntity<ApiPageResponse<ProductResponse>> findProducts(@PathVariable("keyword") String searchInfo,
                                                                     @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int size) {

        Page<ProductResponse> productsById = productService.findProductsById(searchInfo, page, size);

        return ApiPageResponse.success(productsById, "상품 목록을 조회했습니다.");

    }

    //Update 만들기

    @DeleteMapping
    public void deleteProduct(@RequestParam Long productId){

        productService.deleteProductById(productId);

    }

}
