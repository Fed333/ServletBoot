package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.util.Objects;

/**
 * Class for formatting String objects to Integer.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToIntegerFormatter implements Formatter<String, Integer> {
    @Override
    public Integer format(String source) {
        if (Objects.isNull(source) || source.isBlank()){
            return null;
        }
        return Integer.parseInt(source);
    }
}
