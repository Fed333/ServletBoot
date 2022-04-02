package org.fed333.servletboot.source.properties.impl;

import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.source.input.InputStreamSource;
import org.fed333.servletboot.source.properties.PropertiesSource;

import java.io.IOException;
import java.util.Properties;

/**
 * Base implementation of PropertiesSource.<br>
 * Designed on usage InputStreamSource as a mean to obtain InputStream objects.<br>
 * @see InputStreamSource
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton(type = Singleton.Type.LAZY)
public class BasePropertiesSource implements PropertiesSource {

    /**
     * Mean of obtaining InputStream objects.
     * */
    @Inject
    private InputStreamSource iss;

    @Override
    public Properties getProperties(String name) throws IOException {
        Properties properties = new Properties();
        properties.load(iss.getInputStream(name));
        return properties;
    }
}
