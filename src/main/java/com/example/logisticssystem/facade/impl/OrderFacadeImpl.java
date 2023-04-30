package com.example.logisticssystem.facade.impl;

import com.example.logisticssystem.converter.OrderCreateRequestDtoToOrderConverter;
import com.example.logisticssystem.facade.OrderFacade;
import com.example.logisticssystem.model.dto.OrderCreateRequestDto;
import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderFacadeImpl implements OrderFacade {

    OrderService orderService;

    OrderCreateRequestDtoToOrderConverter orderCreateRequestDtoToOrderConverter;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(OrderCreateRequestDto orderCreateRequestDto) {
        Order order = orderCreateRequestDtoToOrderConverter.convert(orderCreateRequestDto);
        orderService.save(order);
    }
}