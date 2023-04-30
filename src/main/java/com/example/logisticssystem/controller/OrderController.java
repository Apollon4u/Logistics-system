package com.example.logisticssystem.controller;

import com.example.logisticssystem.facade.OrderFacade;
import com.example.logisticssystem.model.dto.OrderCreateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
@Api(value = "Методы для работы с заказами")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderFacade orderFacade;

    @PostMapping
    @ApiOperation("Создать заказ")
    public void create(@RequestBody OrderCreateRequestDto orderCreateRequestDto) {
        orderFacade.save(orderCreateRequestDto);
    }

}