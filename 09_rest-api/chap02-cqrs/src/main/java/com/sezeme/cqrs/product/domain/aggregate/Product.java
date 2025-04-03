package com.sezeme.cqrs.product.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
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

    public void changeProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }
}
