package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import com.example.logisticssystem.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestDtoToUserConverter extends AbstractLogisticsSystemConverter<UserCreateRequestDto, User> {

    @Override
    public void fill(UserCreateRequestDto source, User target) {
        target.setEmail(source.getEmail());
    }
}