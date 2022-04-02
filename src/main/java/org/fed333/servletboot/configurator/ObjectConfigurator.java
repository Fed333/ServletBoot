package org.fed333.servletboot.configurator;

import org.fed333.servletboot.factory.ObjectFactory;
import org.fed333.servletboot.context.ApplicationContext;

/**
 * Configurator interface of plain JavaBeans objects within the ApplicationContext.<br>
 * Configures the object in second stage of creating with ObjectFactory.
 * @see ObjectFactory
 * @see ApplicationContext
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public interface ObjectConfigurator {
    /**
     * Properly configures plain JavaBean within the infrastructure.
     * @since 1.0
     * */
    void configure(Object o, ApplicationContext context);
}