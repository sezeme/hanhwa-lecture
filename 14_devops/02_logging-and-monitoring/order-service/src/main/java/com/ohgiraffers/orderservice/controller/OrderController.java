package com.ohgiraffers.orderservice.controller;

import com.ohgiraffers.orderservice.entity.Order;
import com.ohgiraffers.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order out = orderService.createOrder(order);
        log.info("Order created: {}", out);
        return ResponseEntity.status(HttpStatus.CREATED).body(out);
    }

    @GetMapping
    public ResponseEntity<List<Order>> list() {
        List<Order> orderList = orderService.getAllOrders();
        log.info("Order list : {}", orderList);
        return ResponseEntity.ok(orderList);
    }

}