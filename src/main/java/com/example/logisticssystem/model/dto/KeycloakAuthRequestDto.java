package com.example.logisticssystem.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("email")
    @ApiModelProperty("Имя пользователя для keycloak")
    String username;

    @ApiModelProperty("Пароль для keycloak пользователя")
    String password;

}