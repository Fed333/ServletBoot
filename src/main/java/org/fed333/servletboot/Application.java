package org.fed333.servletboot;

import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.config.Config;
import org.fed333.servletboot.config.impl.JavaConfig;
import org.fed333.servletboot.context.impl.BaseApplicationContext;
import org.fed333.servletboot.factory.impl.BaseObjectFactory;
import org.fed333.servletboot.format.formatter.Formatter;
import org.fed333.servletboot.format.manager.FormatterManager;
import org.fed333.servletboot.source.input.InputStreamSource;
import org.fed333.servletboot.source.input.impl.ClasspathInputStreamSource;
import org.fed333.servletboot.source.properties.PropertiesSource;
import org.fed333.servletboot.source.properties.impl.BasePropertiesSource;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;
import org.fed333.servletboot.web.binding.manager.ParameterBinderManager;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Runner class of the infrastructure. <br>
 * Sets Config implementation, creates ObjectFactory, raises ApplicationContext.
 * @see Config
 * @see BaseObjectFactory
 * @see BaseApplicationContext
 * @author Roman Kovalchuk
 * @version 1.5
 * */
@SuppressWarnings("rawtypes")
public class Application {

    /**
     * Initialize the infrastructure according initial param settings.<br>
     * Raise ApplicationContext.
     * @param packageToScan work package
     * @param ifc2ImplClass configure map with interface to implementation class relation
     * @return raised ApplicationContext object
     * @since 1.1
     * @see BaseApplicationContext
     * */
    public static BaseApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass){
        Map<Class, Class> implClass = getImplClass();

        implClass.putAll(ifc2ImplClass);
        Config config = new JavaConfig(packageToScan, implClass);
        BaseApplicationContext context = new BaseApplicationContext(config);

        BaseObjectFactory factory = new BaseObjectFactory(context);
        context.setFactory(factory);

        initNoLazySingletons(config, context);

        setSupportedFormatters(context);
        setSupportedBinders(context);

        return context;
    }

    /**
     * Puts all singletons which are not lazy to the ApplicationContext right away after its creation and setup.<br>
     * @param config Config with interface to implementation classes
     * @param context ApplicationContext
     * @author Roman Kovalchuk
     * @since 1.1
     * */
    private static void initNoLazySingletons(Config config, BaseApplicationContext context) {
        initNoLazySingletons(config.getSystemScanner(), context);
        initNoLazySingletons(config.getScanner(), context);
    }

    private static void initNoLazySingletons(Reflections scanner, BaseApplicationContext context){
        for (Class<?> clazz : scanner.getTypesAnnotatedWith(Singleton.class)) {
            if (clazz.getAnnotation(Singleton.class).type().equals(Singleton.Type.EAGER)){
                context.getObject(clazz);
            }
        }
    }

    /**
     * Sets all supported formatters.<br>
     * Adds FormatterManager with preliminary put basic Formatters to the ApplicationContext.<br>
     * @param context ApplicationContext
     * @author Roman Kovalchuk
     * @since 1.2
     * */
    private static void setSupportedFormatters(BaseApplicationContext context){
        String packageToScan = Application.class.getPackageName() + ".format.formatter.impl";

        FormatterManager manager = context.getObject(FormatterManager.class);
        Reflections scanner = new Reflections(packageToScan);
        Set<Class<? extends Formatter>> formatters =  scanner.getSubTypesOf(Formatter.class);
        formatters.forEach(formatterClass ->{
            try {
                manager.assignFormatter(formatterClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Sets all supported ParameterBinder objects inside ParameterBinderManager singleton.<br>
     * Settings based on scanning a web.binding.binder.impl package
     * @param context ApplicationContext
     * @author Roman Kovalchuk
     * @since 1.3
     * */
    private static void setSupportedBinders(BaseApplicationContext context){
        String packageToScan = Application.class.getPackageName() + ".web.binding.binder.impl";
        Reflections scanner = new Reflections(packageToScan);
        ParameterBinderManager manager = context.getObject(ParameterBinderManager.class);
        Set<Class<? extends ParameterBinder>> binders = scanner.getSubTypesOf(ParameterBinder.class);
        binders.forEach(pb->{
            try {
                manager.addParameterBinder(pb.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    private static HashMap<Class, Class> getImplClass() {
        return new HashMap<>(Map.of(
                InputStreamSource.class, ClasspathInputStreamSource.class,
                PropertiesSource.class, BasePropertiesSource.class
        ));
    }
}
