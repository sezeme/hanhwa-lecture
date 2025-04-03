package com.sezeme.cqrs.product.command.product.command.application.service;

import com.sezeme.cqrs.common.sevice.FileStorageService;
import com.sezeme.cqrs.product.command.domain.repository.ProductRepository;
import com.sezeme.cqrs.product.command.product.command.application.dto.request.ProductCreateRequest;
import com.sezeme.cqrs.product.domain.aggregate.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final ModelMapper modelMapper;

    @Value("${image.image-url}")
    private String IMAGE_URL;
    /* 상품 등록 */
    @Transactional
    public Long createProduct(
            ProductCreateRequest productCreateRequest,
            MultipartFile productImg
    ) {
        // 1. File 저장 => FileStorageService 를 별도로 정의하고 활용
        String replaceFileName = fileStorageService.storeFile(productImg);

        // 2. DTO -> Entity 변환
        Product newProduct = modelMapper.map(productCreateRequest, Product.class);
        newProduct.changeProductImageUrl(IMAGE_URL + replaceFileName);

        Product product = productRepository.save(newProduct);

        return product.getProductCode();
    }
}
