package com.sezeme.cqrs.product.query;

import com.sezeme.cqrs.common.dto.ApiResponse;
import com.sezeme.cqrs.product.query.dto.request.ProductSearchRequest;
import com.sezeme.cqrs.product.query.dto.response.ProductDetailResponse;
import com.sezeme.cqrs.product.query.dto.response.ProductListResponse;
import com.sezeme.cqrs.product.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable Long productCode) {
        ProductDetailResponse response = productQueryService.getProduct(productCode);

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
            ProductSearchRequest productSearchRequest
    ) {
        ProductListResponse response = productQueryService.getProducts(productSearchRequest);

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
