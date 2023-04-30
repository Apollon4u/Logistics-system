package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.OrderResponseDto;
import com.example.logisticssystem.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderResponseDtoConverter extends AbstractLogisticsSystemConverter<Order, OrderResponseDto> {

    @Override
    public void fill(Order source, OrderResponseDto target) {
        target.setId(source.getId());
        target.setMovingDate(source.getMovingDate());
        target.setPacking(source.isPacking());
        target.setLoading(source.isLoading());
        target.setCarId(source.getCarId());
        target.setDistance(source.getDistance());
        target.setPointAName(source.getPointAName());
        target.setPointA(source.getPointA());
        target.setPointBName(source.getPointBName());
        target.setPointB(source.getPointB());
    }
}