package org.fed333.servletboot.source.input;

import org.fed333.servletboot.annotation.Singleton;

import java.io.InputStream;

/**
 * Interface designed for establishing source of resources.<br>
 * To run smoothly implementations should be annotated with @Singleton annotation.<br>
 * @see Singleton
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public interface InputStreamSource {

    /**
     * Gives corresponding InputStream in the specific way.
     * @param name resource name
     * @return InputStream by given resource name
     * @since 1.0
     * */
    InputStream getInputStream(String name);
}