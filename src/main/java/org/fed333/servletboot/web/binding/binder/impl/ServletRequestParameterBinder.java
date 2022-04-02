package org.fed333.servletboot.web.binding.binder.impl;

import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;

/**
 * Designed for binding ServletRequest to controllers methods.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class ServletRequestParameterBinder implements ParameterBinder {

    @Override
    public Object bindParameter(Parameter parameter, HttpServletRequest req, HttpServletResponse res, ApplicationContext context) {
        return req;
    }

    @Override
    public boolean matchesParameter(Parameter parameter) {
        return ServletRequest.class.isAssignableFrom(parameter.getType());
    }
}
