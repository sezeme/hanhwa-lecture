package com.sezeme.cqrs.product.command.infrastructure.repository;

import com.sezeme.cqrs.product.command.domain.repository.ProductRepository;
import com.sezeme.cqrs.product.domain.aggregate.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepostiory extends ProductRepository, JpaRepository<Product, Long> {

}
