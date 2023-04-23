package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Component
public class AccessTokenResponseConverter
        extends AbstractLogisticsSystemConverter<AccessTokenResponse, KeycloakAuthResponseDto> {

    @Override
    public void fill(AccessTokenResponse source, KeycloakAuthResponseDto target) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, (int) source.getRefreshExpiresIn());
        String refreshTokenExpDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX",
                Locale.getDefault(Locale.Category.FORMAT)).format(calendar.getTime());
        target.setAccessToken(source.getToken());
        target.setExpiresIn((int) source.getExpiresIn());
        target.setRefreshExpiresIn((int) source.getRefreshExpiresIn());
        target.setRefreshToken(source.getRefreshToken());
        target.setRefreshTokenExpDate(refreshTokenExpDate);
        target.setTokenType(source.getTokenType());
        target.setSessionState(source.getSessionState());
        target.setScope(source.getScope());
    }
}