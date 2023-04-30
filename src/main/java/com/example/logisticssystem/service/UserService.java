package com.example.logisticssystem.service;

import com.example.logisticssystem.model.entity.User;

public interface UserService {

    void create(User user);

    User getByEmail(String email);

}