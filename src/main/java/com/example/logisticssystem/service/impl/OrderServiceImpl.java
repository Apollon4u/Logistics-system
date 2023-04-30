package com.example.logisticssystem.service.impl;

import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.repository.OrderRepository;
import com.example.logisticssystem.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

}