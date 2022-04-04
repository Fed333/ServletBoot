package org.fed333.servletboot.config;

import org.reflections.Reflections;

/**
 * Interface of Configuration for establishing implementation classes for interfaces.
 * @author Roman Kovalchuk
 * @version 1.1
 * */
public interface Config {

    /**
     * Gives type which implements according interface
     * @param ifc interface to find its implementation
     * @return type which implement ifc interface
     * @since 1.0
     * */
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    /**
     * Gives scanner which is configured to custom application package.<br>
     * Common usage for scanning java packages in finding implementations.
     * @since 1.0
     * @return scanner which scans custom application package
     * @see Reflections
     * */
    Reflections getScanner();

    /**
     * Gives scanner which is configured to {@link org.fed333.servletboot} package.<br>
     * Common usage for scanning java packages in finding implementations.
     * @since 1.1
     * @return scanner which scans {@link org.fed333.servletboot} package
     * @see Reflections
     * */
    Reflections getSystemScanner();
}
