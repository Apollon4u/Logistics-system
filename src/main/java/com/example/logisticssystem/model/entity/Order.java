package com.example.logisticssystem.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document("orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    String id;

    @DBRef
    User user;

    Date movingDate;

    boolean packing;

    boolean loading;

    String carId;

    Double distance;

    String pointAName;

    List<Double> pointA;

    String pointBName;

    List<Double> pointB;

}