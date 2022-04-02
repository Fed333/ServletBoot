package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.util.Objects;
/**
 * Class for formatting String objects to Short.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToShortFormatter implements Formatter<String, Short> {

    @Override
    public Short format(String source) {
        if (Objects.isNull(source) || source.isBlank()){
            return null;
        }
        return Short.parseShort(source);
    }
}
