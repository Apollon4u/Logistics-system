package com.example.logisticssystem.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KeycloakAuthResponseDto {

    String accessToken;

    Integer expiresIn;

    Integer refreshExpiresIn;

    String refreshToken;

    String refreshTokenExpDate;

    String tokenType;

    String sessionState;

    String scope;

}