package org.fed333.servletboot.configurator;

import org.fed333.servletboot.annotation.PropertyValue;
import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.source.properties.PropertiesSource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Configurator of setting property value to the field annotated with @PropertyValue annotation.
 * Gets property value from pointed in annotation property file.
 * @see PropertyValue
 * @author Roman Kovalchuk
 * @version 1.2
 * */
@SuppressWarnings("unused")
public class PropertyValueAnnotationObjectConfigurator implements ObjectConfigurator{

    /**
     * Configure plain JavaBean objects annotated with @PropertyValue annotation.
     * @since 1.0
     * @see PropertyValue
     * */
    @Override
    public void configure(Object o, ApplicationContext context) {
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(PropertyValue.class)){
                PropertyValue annotation = field.getAnnotation(PropertyValue.class);
                Properties properties;
                try {
                    properties = context.getObject(PropertiesSource.class).getProperties(buildPathToPropertiesFile(annotation));
                } catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("Cannot set property for field " + field + ". File " + buildPathToPropertiesFile(annotation) + " wasn't found or opened.");
                }
                String value = properties.getProperty(!annotation.property().isBlank() ? annotation.property() : field.getName());
                field.setAccessible(true);
                try {
                    field.set(o, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Cannot set value " + value + " to the field " + field, e);
                }
            }
        }
    }

    /**
     * Builds path to properties file, according to the data in @PropertyValue annotation
     * @param annotation source of file path data
     * @since 1.1
     * */
    private String buildPathToPropertiesFile(PropertyValue annotation) {
        return annotation.prefixPath() + annotation.filePath();
    }
}
