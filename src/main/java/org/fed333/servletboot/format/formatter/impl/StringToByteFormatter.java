package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.util.Objects;

/**
 * Class for formatting String objects to Byte.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToByteFormatter implements Formatter<String, Byte> {

    @Override
    public Byte format(String source) {
        if (Objects.isNull(source) || source.isBlank()){
            return null;
        }
        return Byte.parseByte(source);
    }
}
