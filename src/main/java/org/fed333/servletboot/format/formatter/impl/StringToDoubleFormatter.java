package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.util.Objects;

/**
 * Class for formatting String objects to Double.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToDoubleFormatter implements Formatter<String, Double> {

    @Override
    public Double format(String source) {
        if (Objects.isNull(source) || source.isBlank()){
            return null;
        }
        return Double.parseDouble(source);
    }
}
