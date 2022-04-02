package org.fed333.servletboot.web.binding.binder.impl;

import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;

/**
 * Designed for binding ServletResponse to controllers methods.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class ServletResponseParameterBinder implements ParameterBinder {

    @Override
    public Object bindParameter(Parameter parameter, HttpServletRequest req, HttpServletResponse res, ApplicationContext context) {
        return res;
    }

    @Override
    public boolean matchesParameter(Parameter parameter) {
        return ServletResponse.class.isAssignableFrom(parameter.getType());
    }
}
