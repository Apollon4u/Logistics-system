package com.example.logisticssystem.converter;

public interface LogisticsSystemFilter<S, T> {

    /**
     * Маппит значения из source в target
     * @param source источник данных
     * @param target цель маппинга
     */
    void fill(S source, T target);

    T createTarget();

}