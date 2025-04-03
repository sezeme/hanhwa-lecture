package com.sezeme.cqrs.product.query.service;

import com.sezeme.cqrs.common.dto.Pagination;
import com.sezeme.cqrs.exception.BusinessException;
import com.sezeme.cqrs.exception.ErrorCode;
import com.sezeme.cqrs.product.query.dto.response.ProductDetailResponse;
import com.sezeme.cqrs.product.query.dto.request.ProductSearchRequest;
import com.sezeme.cqrs.product.query.dto.response.ProductDto;
import com.sezeme.cqrs.product.query.dto.response.ProductListResponse;
import com.sezeme.cqrs.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductMapper productMapper;

    /* 상품 상세 조회 */
    @Transactional(readOnly = true)
    public ProductDetailResponse getProduct(Long productCode) {

        ProductDto product = Optional.ofNullable(productMapper.selectProductByCode(productCode))
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        return ProductDetailResponse.builder()
                .product(product)
                .build();
    }

    /* 상품 상세 조회 */
    @Transactional(readOnly = true)
    public ProductListResponse getProducts(ProductSearchRequest productSearchRequest) {

        // 필요한 컨텐츠 조회
        List<ProductDto> products = productMapper.selectProducts(productSearchRequest);
        // 해당 검색 조건으로 총 몇개의 컨텐츠가 있는지 조회 (페이징을 위한 속성 값 계산이 필요)
        long totalItems = productMapper.countProducts(productSearchRequest);

        int page = productSearchRequest.getPage();
        int size = productSearchRequest.getSize();


        return ProductListResponse.builder()
                .products(products)
                .pagination(Pagination.builder()
                        .currentPage(page)
                        .totalPage((int) Math.ceil((double) totalItems / size))
                        .totalItems(totalItems)
                        .build())
                .build();
    }
}
