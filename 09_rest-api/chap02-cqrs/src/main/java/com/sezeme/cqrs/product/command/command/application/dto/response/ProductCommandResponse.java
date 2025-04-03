package com.sezeme.cqrs.product.command.command.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCommandResponse {
    private final Long productCode;
}
