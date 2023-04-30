package com.example.logisticssystem.converter;

import com.example.logisticssystem.model.dto.OrderCreateRequestDto;
import com.example.logisticssystem.model.entity.Order;
import com.example.logisticssystem.service.UserService;
import com.example.logisticssystem.utils.JwtUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderCreateRequestDtoToOrderConverter
        extends AbstractLogisticsSystemConverter<OrderCreateRequestDto, Order> {

    UserService userService;

    @Override
    public void fill(OrderCreateRequestDto source, Order target) {
        target.setPacking(source.isPacking());
        target.setDistance(source.getDistance());
        target.setLoading(source.isLoading());
        target.setCarId(source.getCarId());
        target.setMovingDate(Timestamp.valueOf(source.getMovingDate()));
        target.setPointAName(source.getPointAName());
        target.setPointA(source.getPointA());
        target.setPointBName(source.getPointBName());
        target.setPointB(source.getPointB());
        String email = JwtUtils.getUserName();
        target.setUser(userService.getByEmail(email));
    }

}