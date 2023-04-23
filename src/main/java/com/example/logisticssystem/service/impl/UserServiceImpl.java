package com.example.logisticssystem.service.impl;

import com.example.logisticssystem.model.entity.User;
import com.example.logisticssystem.repository.UserRepository;
import com.example.logisticssystem.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }
}