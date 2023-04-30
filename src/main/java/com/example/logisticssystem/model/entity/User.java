package com.example.logisticssystem.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    String id;

    String email;

    String keycloakId;

    /**
     * Дата регистрации пользователя
     */
    Date createdDate;

}