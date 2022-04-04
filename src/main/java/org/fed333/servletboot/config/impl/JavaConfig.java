package org.fed333.servletboot.config.impl;

import org.fed333.servletboot.Application;
import org.fed333.servletboot.config.Config;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * Config implementation based on Java language configuration.
 * @see Config
 * @author Roman Kovalchuk
 * @version 1.1
 * */
@SuppressWarnings({"unchecked", "rawtypes"})
public class JavaConfig implements Config {

    private final Reflections scanner;

    private final Reflections systemScanner;

    /**
     * Map of interface to implementation relations.
     * @since 1.0
     * */
    private final Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.systemScanner = new Reflections(Application.class.getPackageName());
        this.scanner = new Reflections(packageToScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {

        return ifc2ImplClass.computeIfAbsent(ifc, clazz -> {
            Set<Class<? extends T>> classes = getSubTypesOf(ifc);
            if (classes.size() != 1){
                throw new RuntimeException(ifc + " has 0 or more than 1 implementation was found! Please update your config.");
            }
            return classes.iterator().next();
        });
    }

    private <T> Set<Class<? extends T>> getSubTypesOf(Class<T> ifc) {
        Set<Class<? extends T>> subTypesOf = systemScanner.getSubTypesOf(ifc);
        return !subTypesOf.isEmpty() ? subTypesOf : scanner.getSubTypesOf(ifc);
    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }

    @Override
    public Reflections getSystemScanner() {
        return systemScanner;
    }
}
