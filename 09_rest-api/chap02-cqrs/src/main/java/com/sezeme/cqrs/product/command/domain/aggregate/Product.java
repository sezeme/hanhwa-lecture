package com.sezeme.cqrs.product.command.domain.aggregate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE tbl_product SET status = 'DELETED' WHRER product_code = ?")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    private String productName;
    private Long productPrice;
    private String productDescription;
    private Long categoryCode;
    private String productImageUrl;
    private Long productStock;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status = ProductStatus.USABLE;

    // 이미지 변경 시 사용 될 메소드
    public void changeProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public void updateProductDetails(@NotBlank String productName, @Min(value = 1) Long productPrice, @NotBlank String productDescription, @Min(value = 1) Long categoryCode, @Min(value = 1) Long productStock, ProductStatus productStatus) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.categoryCode = categoryCode;
        this.productStock = productStock;
        this.status = productStatus;
    }
}
