package org.fed333.servletboot.testing.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to mark beans to mock.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface MockBean {
}
