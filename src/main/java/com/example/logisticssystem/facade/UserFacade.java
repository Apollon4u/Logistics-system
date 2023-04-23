package com.example.logisticssystem.facade;

import com.example.logisticssystem.model.dto.KeycloakAuthRequestDto;
import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import com.example.logisticssystem.model.dto.UserCreateRequestDto;

public interface UserFacade {

    /**
     * Регистрация пользователя
     *
     * @param userCreateRequestDto Запрос авторизации
     */
    void create(UserCreateRequestDto userCreateRequestDto);

    /**
     * Авторизация пользователя
     *
     * @param keycloakAuthRequestDto Запрос авторизации
     * @return Токен доступа
     */
    KeycloakAuthResponseDto login(KeycloakAuthRequestDto keycloakAuthRequestDto);

}