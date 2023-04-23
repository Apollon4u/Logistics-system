package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.UserCreateRequestDto;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestDtoToUserRepresentationConverter
        extends AbstractLogisticsSystemConverter<UserCreateRequestDto, UserRepresentation> {

    @Override
    public void fill(UserCreateRequestDto source, UserRepresentation target) {
        target.setUsername(source.getEmail());
        target.setEmail(source.getEmail());
        target.setEnabled(true);
    }
}