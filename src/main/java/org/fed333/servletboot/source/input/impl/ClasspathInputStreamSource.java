package org.fed333.servletboot.source.input.impl;

import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.source.input.InputStreamSource;

import java.io.InputStream;

/**
 * Base implementation designed on loading resources from classpath with Reflection API usage.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton(type = Singleton.Type.LAZY)
public class ClasspathInputStreamSource implements InputStreamSource {

    @Override
    public InputStream getInputStream(String name) {
        return getClass().getClassLoader().getResourceAsStream(name);
    }
}
