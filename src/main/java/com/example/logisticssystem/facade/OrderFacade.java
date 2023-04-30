package com.example.logisticssystem.facade;

import com.example.logisticssystem.model.dto.OrderCreateRequestDto;
import com.example.logisticssystem.model.dto.OrderResponseDto;

import java.util.List;

public interface OrderFacade {

    void save(OrderCreateRequestDto orderCreateRequestDto);

    List<OrderResponseDto> getAll();

}