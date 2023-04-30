package com.example.logisticssystem.facade.impl;

import com.example.logisticssystem.converter.OrderCreateRequestDtoToOrderConverter;
import com.example.logisticssystem.converter.OrderToOrderResponseDtoConverter;
import com.example.logisticssystem.facade.OrderFacade;
import com.example.logisticssystem.model.dto.OrderCreateRequestDto;
import com.example.logisticssystem.model.dto.OrderResponseDto;
import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.model.entity.User;
import com.example.logisticssystem.service.OrderService;
import com.example.logisticssystem.service.UserService;
import com.example.logisticssystem.utils.JwtUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderFacadeImpl implements OrderFacade {

    UserService userService;
    OrderService orderService;

    OrderToOrderResponseDtoConverter orderToOrderResponseDtoConverter;
    OrderCreateRequestDtoToOrderConverter orderCreateRequestDtoToOrderConverter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OrderCreateRequestDto orderCreateRequestDto) {
        Order order = orderCreateRequestDtoToOrderConverter.convert(orderCreateRequestDto);
        orderService.save(order);
    }

    @Override
    public List<OrderResponseDto> getAll() {
        String email = JwtUtils.getUserName();
        User user = userService.getByEmail(email);
        List<Order> orders = orderService.getByUser(user);
        return orderToOrderResponseDtoConverter.convert(orders);
    }

}