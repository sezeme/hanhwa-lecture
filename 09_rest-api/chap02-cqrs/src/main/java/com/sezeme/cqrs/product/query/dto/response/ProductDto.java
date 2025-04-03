package com.sezeme.cqrs.product.query.dto.response;

import lombok.Getter;
import lombok.Setter;

/* 모든 값을 적지 않고, 내가 사용할 값만 담는다. */
@Getter
@Setter
public class ProductDto {
    private Long productCode;
    private String productName;
    private Long productPrice;
    private String productDescription;
    private CategoryDto category;
    private String productImageUrl;
    private Long productStock;
}
