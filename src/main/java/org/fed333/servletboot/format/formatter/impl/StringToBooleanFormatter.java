package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

/**
 * Class for formatting String objects to Boolean.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToBooleanFormatter implements Formatter<String, Boolean> {

    @Override
    public Boolean format(String source) {
        return Boolean.parseBoolean(source);
    }
}
