package com.example.logisticssystem.facade.impl;

import com.example.logisticssystem.converter.UserCreateRequestDtoToUserConverter;
import com.example.logisticssystem.converter.UserCreateRequestDtoToUserRepresentationConverter;
import com.example.logisticssystem.facade.UserFacade;
import com.example.logisticssystem.model.dto.KeycloakAuthRequestDto;
import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import com.example.logisticssystem.model.entity.User;
import com.example.logisticssystem.service.KeycloakService;
import com.example.logisticssystem.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserFacadeImpl implements UserFacade {

    UserService userService;
    KeycloakService keycloakService;
    UserCreateRequestDtoToUserConverter userCreateRequestDtoToUserConverter;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void create(UserCreateRequestDto userCreateRequestDto) {
        String keycloakId = keycloakService.createAndGetKeycloakId(userCreateRequestDto);
        User user = userCreateRequestDtoToUserConverter.convert(userCreateRequestDto);
        user.setKeycloakId(keycloakId);
        userService.create(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeycloakAuthResponseDto login(KeycloakAuthRequestDto keycloakAuthRequestDto) {
        return keycloakService.login(keycloakAuthRequestDto);
    }
}