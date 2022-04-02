package org.fed333.servletboot.web.binding.binder.impl;

import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.web.Model;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.Objects;

/**
 * Designed for binding Model web to controllers methods.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public class ModelParameterBinder implements ParameterBinder {

    @Override
    public Object bindParameter(Parameter parameter, HttpServletRequest req, HttpServletResponse res, ApplicationContext context) {
        if (Objects.isNull(req.getAttribute(Model.class.getName()))){
            req.setAttribute(Model.class.getName(), context.getObject(Model.class));
        }
        return req.getAttribute(Model.class.getName());
    }

    @Override
    public boolean matchesParameter(Parameter parameter) {
        return Model.class.isAssignableFrom(parameter.getType());
    }
}
