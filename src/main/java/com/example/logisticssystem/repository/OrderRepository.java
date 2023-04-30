package com.example.logisticssystem.repository;

import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> getByUser(User user);

}