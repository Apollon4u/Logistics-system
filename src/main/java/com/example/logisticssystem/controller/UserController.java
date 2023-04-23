package com.example.logisticssystem.controller;

import com.example.logisticssystem.facade.UserFacade;
import com.example.logisticssystem.model.dto.KeycloakAuthRequestDto;
import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@Api(value = "Методы для работы с пользователями")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserFacade userFacade;

    @PostMapping
    @ApiOperation("Создать пользователя")
    public void createEmployee(@RequestBody UserCreateRequestDto userCreateRequestDto) {
        userFacade.create(userCreateRequestDto);
    }

    @PostMapping("/login")
    @ApiOperation("Получить токен доступа")
    public KeycloakAuthResponseDto login(@RequestBody KeycloakAuthRequestDto keycloakAuthRequestDto) {
        return userFacade.login(keycloakAuthRequestDto);
    }

}