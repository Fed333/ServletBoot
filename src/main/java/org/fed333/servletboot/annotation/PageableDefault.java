package org.fed333.servletboot.annotation;

import org.fed333.servletboot.web.data.sort.Order;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Contains default page data.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface PageableDefault {

    int page() default 0;

    int size() default 10;

    String[] sort() default {};

    Order.Direction[] directions() default {};

}
