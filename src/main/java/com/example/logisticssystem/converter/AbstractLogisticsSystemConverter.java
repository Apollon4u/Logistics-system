package com.example.logisticssystem.converter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractLogisticsSystemConverter<S, T> implements LogisticsSystemConverter<S, T>, LogisticsSystemFilter<S, T> {

    @Override
    public T createTarget() {
        Class<T> clazz = (Class)
                ((ParameterizedType)
                        getClass()
                                .getGenericSuperclass())
                        .getActualTypeArguments()[1];
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(String.format("Не удалось создать экземпляр класса %s, " +
                    "возможно не был задан конструктор без параметров", clazz.getName()), e);
        }
    }

    public T safeConvert(S s) {
        try {
            return nullableConvert(s);
        } catch (Exception e) {
            log.error("safe convert exception!", e);
            return null;
        }
    }

    public Optional<T> optionalConvert(S s) {
        if (s == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(convert(s));
    }

    public List<T> convert(List<S> s) {
        if (CollectionUtils.isEmpty(s)) {
            return Collections.emptyList();
        }
        return s.stream().map(this::convert).collect(Collectors.toList());
    }

    public Set<T> convert(Set<S> s) {
        if (CollectionUtils.isEmpty(s)) {
            return Collections.emptySet();
        }
        return s.stream().map(this::convert).collect(Collectors.toSet());
    }

    public T nullableConvert(S source) {
        if (source == null) {
            return null;
        }
        return convert(source);
    }

    @Override
    @NonNull
    public T convert(S source) {
        T target = createTarget();
        abstractFill(source, target);
        fill(source, target);
        return target;
    }

    public void abstractFill(S source, T target) {
    }

}