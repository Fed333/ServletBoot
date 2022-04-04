package org.fed333.servletboot.testing.source;

import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.source.input.InputStreamSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Test implementation of InputStreamSource infrastructure interface.<br>
 * Based on work with source file by means of FileInputStream.<br>
 * @see InputStreamSource
 * @see FileInputStream
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton(type = Singleton.Type.LAZY)
public class TestInputStreamSource implements InputStreamSource {

    @Override
    public InputStream getInputStream(String name) {
        try {
            return new FileInputStream(name);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No files were found with name: " + name, e);
        }
    }
}
