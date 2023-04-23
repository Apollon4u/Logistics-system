package com.example.logisticssystem.service;

import com.example.logisticssystem.model.dto.KeycloakAuthRequestDto;
import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import com.example.logisticssystem.model.dto.UserCreateRequestDto;

public interface KeycloakService {

    String createAndGetKeycloakId(UserCreateRequestDto userCreateRequestDto);

    /**
     * Авторизация пользователя
     *
     * @param keycloakAuthRequestDto Запрос авторизации
     * @return Токен доступа
     */
    KeycloakAuthResponseDto login(KeycloakAuthRequestDto keycloakAuthRequestDto);

}