package org.fed333.servletboot.testing;

import org.fed333.servletboot.config.Config;
import org.fed333.servletboot.config.impl.JavaConfig;
import org.fed333.servletboot.factory.impl.BaseObjectFactory;
import org.fed333.servletboot.source.input.InputStreamSource;
import org.fed333.servletboot.source.properties.PropertiesSource;
import org.fed333.servletboot.testing.context.MockApplicationContext;
import org.fed333.servletboot.testing.source.TestInputStreamSource;
import org.fed333.servletboot.testing.source.TestPropertiesSource;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TestApplication {

    public static MockApplicationContext run(Class<?> testClass, String packageToScan) {
        return run(testClass, packageToScan, new HashMap<>());
    }

    public static MockApplicationContext run(Class<?> testClass, String packageToScan, Map<Class<?>, Class<?>> ifc2Impl) {
        Map<Class<?>, Class<?>> implMap = getImplMap();
        implMap.putAll(ifc2Impl);
        Config config = new JavaConfig(packageToScan, new HashMap<>(implMap));
        MockApplicationContext context = new MockApplicationContext(testClass, config);
        BaseObjectFactory factory = new BaseObjectFactory(context);
        context.setFactory(factory);
        return context;
    }

    @NotNull
    private static Map<Class<?>, Class<?>> getImplMap() {
        return new HashMap<>(Map.of(
                InputStreamSource.class, TestInputStreamSource.class,
                PropertiesSource.class, TestPropertiesSource.class
        ));
    }
}
