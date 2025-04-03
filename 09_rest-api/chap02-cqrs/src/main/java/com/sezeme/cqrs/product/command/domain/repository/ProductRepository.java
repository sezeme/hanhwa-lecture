package com.sezeme.cqrs.product.command.domain.repository;

import com.sezeme.cqrs.product.domain.aggregate.Product;

public interface ProductRepository {
    Product save(Product product);
}
