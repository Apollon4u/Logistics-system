package com.example.logisticssystem.converter;

import org.springframework.lang.NonNull;

@FunctionalInterface
public interface LogisticsSystemConverter<S, T> {
    @NonNull
    T convert(S var1);
}