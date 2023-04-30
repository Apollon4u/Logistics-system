package com.example.logisticssystem.facade;

import com.example.logisticssystem.model.dto.OrderCreateRequestDto;

public interface OrderFacade {

    void save(OrderCreateRequestDto orderCreateRequestDto);

}