package org.fed333.servletboot.context;

import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.config.Config;
import org.fed333.servletboot.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Context within the infrastructure works.
 * @author Roman Kovalchuk
 * @version 1.3
 * */
public class ApplicationContext {

    /**
     * Factory for creation and configuring plain JavaBeans objects within the infrastructure.
     * @since 1.0
     * @see ObjectFactory
     * */
    private ObjectFactory factory;

    /**
     * Config for establishing implementation classes for interfaces.
     * @since 1.0
     * @see Config
     * */
    private final Config config;

    /**
     * Cache of all plain JavaBeans singletons.<br>
     * Contains only objects annotated with @Singleton annotation
     * @since 1.0
     * @see Singleton
     * */
    private final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    /**
     * Gives plain JavaBean object.<br>
     * Creates the object with ObjectFactory if it is absent in the cache.<br>
     * Caches singletons objects.
     * @param clazz Type of object being created
     * @return Created and configured plain JavaBean object within ApplicationContext
     * @since 1.0
     * @see ObjectFactory
     * */
    public <T> T getObject(Class<T> clazz){

        if (cache.containsKey(clazz)){
            @SuppressWarnings("unchecked")
            T t = (T) cache.get(clazz);
            return t;
        }

        Class<? extends T> implClass = clazz;
        if (clazz.isInterface()){
            implClass = config.getImplClass(clazz);
        }

        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)){
            cache.put(clazz, t);
            factory.popClass(implClass);
        }

        return t;
    }

    public void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    /**
     * Gives application {@link Config} with encapsulated logic of establishing implementation classes for interfaces.
     * @since 1.0
     * @see Config
     * */
    public Config getConfig() {
        return config;
    }

}
