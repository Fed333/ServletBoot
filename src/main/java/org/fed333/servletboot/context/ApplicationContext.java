package org.fed333.servletboot.context;

import org.fed333.servletboot.config.Config;
import org.fed333.servletboot.factory.ObjectFactory;
import org.fed333.servletboot.factory.impl.BaseObjectFactory;

/**
 * Context within the infrastructure works.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public interface ApplicationContext {

    /**
     * Gives plain JavaBean object.<br>
     * Creates the object with ObjectFactory if it is absent in the cache.<br>
     * Caches singletons objects.
     * @param clazz Type of object being created
     * @return Created and configured plain JavaBean object within ApplicationContext
     * @since 1.0
     * @see BaseObjectFactory
     * */
    <T> T getObject(Class<T> clazz);

    /**
     * Gives application {@link Config} with encapsulated logic of establishing implementation classes for interfaces.
     * @since 1.0
     * @see Config
     * */
    Config getConfig();

}
