package com.aenesgur.orderservice.service;

import com.aenesgur.orderservice.model.dto.OrderDto;
import com.aenesgur.orderservice.model.dto.OrderItemDto;
import com.aenesgur.orderservice.model.entity.Order;
import com.aenesgur.orderservice.model.entity.OrderItem;
import com.aenesgur.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public void createOrder(OrderDto orderDto) {

        //TODO: INVENTORY SERVICE CHECK
        //TODO: IF IT IS TRUE, SAVE ORDER TO DB AND QUEUE TO SMS SERVICE

        orderRepository.save(mapToEntity(orderDto));
    }

    private Order mapToEntity(OrderDto orderDto){
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderDto.getOrderItemDtoList()){
            OrderItem orderItem = OrderItem.builder()
                    .ref(orderItemDto.getRef())
                    .price(orderItemDto.getPrice())
                    .quantity(orderItemDto.getQuantity())
                    .build();
            orderItems.add(orderItem);
        }

        return Order.builder()
                .orderItems(orderItems)
                .build();
    }
}
