package org.fed333.servletboot.web.binding.binder.impl;

import org.fed333.servletboot.annotation.RequestParam;
import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.format.manager.FormatterManager;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.Objects;

import static org.fed333.servletboot.web.binding.utils.BindingUtils.bindType;
import static org.fed333.servletboot.web.binding.utils.BindingUtils.convertTypeFromString;

/**
 * Binds web parameters annotated with @RequestParam annotation.
 * @author Roman Kovalchuk
 * @see ParameterBinder
 * @see RequestParam
 * @version 1.1
 * */
public class RequestParamAnnotationParameterBinder implements ParameterBinder {

    @Override
    public Object bindParameter(Parameter parameter, HttpServletRequest req, HttpServletResponse res, ApplicationContext context) {
        RequestParam paramAnnotation = parameter.getAnnotation(RequestParam.class);
        Class<?> parameterClass = parameter.getType();
        Object bind = bindType(parameterClass, req, paramAnnotation.name(), context);
        if (Objects.isNull(bind) && paramAnnotation.required()){
            if (parameterClass.isAssignableFrom(paramAnnotation.defaultValue().getClass())){
                return paramAnnotation.defaultValue();
            } else {
                return convertTypeFromString(paramAnnotation.defaultValue(), parameterClass, context.getObject(FormatterManager.class));
            }
        }
        return bind;
    }

    @Override
    public boolean matchesParameter(Parameter parameter) {
        return parameter.isAnnotationPresent(RequestParam.class);
    }
}