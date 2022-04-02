package org.fed333.servletboot.annotation;

import org.fed333.servletboot.web.data.sort.Sort;

import java.awt.print.Pageable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify web parameter name of bind value.<br>
 * Adds additional prefix to parameter name so that get it separated.<br>
 * Can be applied to {@link DTO}, {@link Pageable} and {@link Sort} objects.<br>
 * For example @Qualifier("bar") will add "bar_" to name of bind parameter.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Qualifier {
    String value();
}