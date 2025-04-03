package com.sezeme.cqrs.product.query.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private Long categoryCode;
    private String categoryName;
}
