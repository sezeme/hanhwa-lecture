package com.sezeme.cqrs.product.command.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor
public class ProductCreateRequest {
    @NotBlank
    private final String productName;
    @Min(value = 1)
    private final Long productPrice;
    @NotBlank
    private final String productDescription;
    @Min(value = 1)
    private final Long categoryCode;
    @Min(value = 1)
    private final Long productStock;
}
