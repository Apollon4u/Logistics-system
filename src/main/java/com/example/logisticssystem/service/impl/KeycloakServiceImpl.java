package com.example.logisticssystem.service.impl;

import com.example.logisticssystem.converter.AccessTokenResponseConverter;
import com.example.logisticssystem.converter.UserCreateRequestDtoToUserRepresentationConverter;
import com.example.logisticssystem.model.dto.KeycloakAuthRequestDto;
import com.example.logisticssystem.model.dto.KeycloakAuthResponseDto;
import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import com.example.logisticssystem.service.KeycloakService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KeycloakServiceImpl implements KeycloakService {

    Keycloak userKeycloak;

    UsersResource usersResource;

    @Value("${keycloak.auth-server-url}")
    String url;

    @Value("${keycloak.realm}")
    String myRealm;

    @Value("${keycloak.resource}")
    String clientName;

    @Value("${keycloak.client-secret}")
    String clientSecret;

    final AccessTokenResponseConverter accessTokenResponseConverter;
    final UserCreateRequestDtoToUserRepresentationConverter userCreateRequestDtoToUserRepresentationConverter;

    @Override
    public String createAndGetKeycloakId(UserCreateRequestDto userCreateRequestDto) {
        UserRepresentation userRepresentation = userCreateRequestDtoToUserRepresentationConverter.convert(userCreateRequestDto);
        CredentialRepresentation credentialRepresentation = getPasswordCredential(userCreateRequestDto.getPassword());
        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));
        usersResource.create(userRepresentation);
        return getKeycloakId(userCreateRequestDto.getEmail());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeycloakAuthResponseDto login(KeycloakAuthRequestDto dto) {
        userKeycloak = Keycloak.getInstance(url, myRealm,
                dto.getUsername(), dto.getPassword(),
                clientName, clientSecret);
        AccessTokenResponse accessTokenResponse = userKeycloak.tokenManager().grantToken();
        return accessTokenResponseConverter.convert(accessTokenResponse);
    }

    private String getKeycloakId(String username) {
        List<UserRepresentation> userRepresentations = usersResource.search(username);
        UserRepresentation userRepresentation = userRepresentations.get(0);
        return userRepresentation.getId();
    }

    /**
     * Создание креда для пароля
     *
     * @param password Новый пароль
     * @return Новый кред
     */
    private CredentialRepresentation getPasswordCredential(String password) {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(password);
        credentialRepresentation.setTemporary(false);
        return credentialRepresentation;
    }

}