package com.aenesgur.orderservice.service;

import com.aenesgur.orderservice.model.dto.OrderDto;

public interface OrderService{
    void createOrder(OrderDto orderDto);
}
