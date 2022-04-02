package org.fed333.servletboot.format.formatter.impl;

import org.fed333.servletboot.format.formatter.Formatter;

import java.time.LocalDate;

/**
 * Class for formatting {@link String} objects to {@link LocalDate}.<br>
 * Default date pattern is yyyy-MM-dd
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class StringToLocalDateFormatter implements Formatter<String, LocalDate> {

    @Override
    public LocalDate format(String source) {
        return LocalDate.parse(source);
    }
}