package com.aenesgur.orderservice.controller;

import com.aenesgur.orderservice.model.dto.OrderDto;
import com.aenesgur.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @CircuitBreaker(name = "product-stock", fallbackMethod = "productStockFallbackMethod")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return new ResponseEntity("Order created succesfully.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> productStockFallbackMethod(OrderDto orderDto, RuntimeException exception){
        return  new ResponseEntity<>("Something went wrong for this operation. Please try later...", HttpStatus.NOT_FOUND);
    }
}
