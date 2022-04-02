package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.util.Objects;

/**
 * Class for formatting String objects to Long.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToLongFormatter implements Formatter<String, Long> {

    @Override
    public Long format(String source) {
        if (Objects.isNull(source) || source.isBlank()){
            return null;
        }
        return Long.parseLong(source);
    }
}
