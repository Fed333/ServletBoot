package org.fed333.servletboot.format.manager.impl;

import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.format.formatter.Formatter;
import org.fed333.servletboot.format.manager.FormatterManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * Base implementation of FormatterManager.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton(type = Singleton.Type.EAGER)
@SuppressWarnings({"unchecked"})
public class BaseFormatterManager implements FormatterManager {

    /**
     * Storage of all registered formatters.
     * */
    private final Map<SimpleImmutableEntry<?,?>, Formatter<?,?>> formatters = new HashMap<>();

    @Override
    public void assignFormatter(Formatter<?, ?> formatter) {

        ParameterizedType genericInterface = (ParameterizedType) formatter.getClass().getGenericInterfaces()[0];
        Type sourceType = genericInterface.getActualTypeArguments()[0];
        Type targetType = genericInterface.getActualTypeArguments()[1];
        formatters.put(new SimpleImmutableEntry<>(sourceType, targetType), formatter);
    }

    @Override
    public <S, T> Optional<Formatter<S, T>> getFormatter(Class<S> formatFromClass, Class<T> formatToClass) {
        return Optional.ofNullable((Formatter<S, T>) formatters.get(new SimpleImmutableEntry<>(formatFromClass, formatToClass)));
    }

    @Override
    public List<Formatter<?, ?>> getAllFormatters() {
        return new ArrayList<>(formatters.values());
    }
}