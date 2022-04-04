package org.fed333.servletboot.testing.context;

import org.fed333.servletboot.config.Config;
import org.fed333.servletboot.context.impl.BaseApplicationContext;
import org.fed333.servletboot.testing.annotation.MockBean;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MockApplicationContext extends BaseApplicationContext {

    private final Map<Class<?>, Object> mocked = new HashMap<>();

    public MockApplicationContext(Class<?> testClass, Config config) {
        super(config);
        for (Field field : testClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(MockBean.class)){
                Class<?> type = field.getType();
                mocked.put(type, Mockito.mock(type));
            }
        }
    }

    @Override
    public <T> T getObject(Class<T> clazz) {
        if (mocked.containsKey(clazz)){
            return (T) mocked.get(clazz);
        }
        return super.getObject(clazz);
    }
}
