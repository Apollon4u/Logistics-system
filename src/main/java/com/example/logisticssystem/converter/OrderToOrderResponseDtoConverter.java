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
        target.setPacking(source.getPacking());
        target.setLoading(source.getLoading());
        target.setCarId(source.getCarId());
        target.setDistance(source.getDistance());
        target.setPointAName(source.getPointAName());
        target.setPointA(source.getPointA());
        target.setPointBName(source.getPointBName());
        target.setPointB(source.getPointB());
        target.setTime(source.getTime());
        target.setNumberOfMovers(source.getNumberOfMovers());
        target.setNumberOfPackers(source.getNumberOfPackers());
    }
}