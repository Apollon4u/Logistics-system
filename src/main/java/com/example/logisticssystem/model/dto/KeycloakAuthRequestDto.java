package com.example.logisticssystem.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel("Объект передачи данных для авторизации пользователя")
public class KeycloakAuthRequestDto {

    @ApiModelProperty("Имя пользователя для keycloak")
    String username;

    @ApiModelProperty("Пароль для keycloak пользователя")
    String password;

}