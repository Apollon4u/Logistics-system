package com.example.logisticssystem.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel("Тело запроса для создания заказа")
public class OrderCreateRequestDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
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