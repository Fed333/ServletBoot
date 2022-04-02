package org.fed333.servletboot.annotation;

import org.fed333.servletboot.configurator.InjectAnnotationObjectConfigurator;
import org.fed333.servletboot.context.ApplicationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks field of plain JavaBean class within ApplicationContext
 * to assign object of corresponding type for annotated field. <br>
 * This annotation can be applied only on objects which are managed with ApplicationContext.<br>
 * The injections are configured with InjectAnnotationObjectConfigurator
 * @see ApplicationContext
 * @see InjectAnnotationObjectConfigurator
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Inject {
}
