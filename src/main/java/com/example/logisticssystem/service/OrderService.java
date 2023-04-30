package com.example.logisticssystem.service;

import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.model.entity.User;

import java.util.List;

public interface OrderService {

    void save(Order order);

    List<Order> getByUser(User user);

}