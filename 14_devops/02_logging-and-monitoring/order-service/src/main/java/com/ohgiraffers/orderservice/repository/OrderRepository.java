package com.ohgiraffers.orderservice.repository;

import com.ohgiraffers.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
