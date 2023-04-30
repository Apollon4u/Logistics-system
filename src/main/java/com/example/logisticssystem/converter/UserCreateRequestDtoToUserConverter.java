package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import com.example.logisticssystem.model.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class UserCreateRequestDtoToUserConverter extends AbstractLogisticsSystemConverter<UserCreateRequestDto, User> {

    @Override
    public void fill(UserCreateRequestDto source, User target) {
        target.setEmail(source.getEmail());
        target.setCreatedDate(Date.from(Instant.now()));
    }
}