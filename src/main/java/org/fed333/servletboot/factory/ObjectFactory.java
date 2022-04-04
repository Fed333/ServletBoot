package org.fed333.servletboot.factory;

/**
 * ObjectFactory interface, for creating plain JavaBeans objects within ApplicationContext
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public interface ObjectFactory {

    /**
     * Creates object according to the given class,
     * the class must have constructor without arguments or default one
     * @param clazz Type of object being created
     * @throws RuntimeException when object creating was failed
     * @return Created and configured plain JavaBean object within ApplicationContext
     * @since 1.0
     * */
    <T> T createObject(Class<T> clazz);

}
