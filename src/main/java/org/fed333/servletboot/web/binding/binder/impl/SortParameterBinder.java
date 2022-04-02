package org.fed333.servletboot.web.binding.binder.impl;

import org.fed333.servletboot.context.ApplicationContext;
import org.fed333.servletboot.web.binding.binder.ParameterBinder;
import org.fed333.servletboot.web.data.sort.Sort;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;

import static org.fed333.servletboot.web.binding.constants.ConstantParameters.SORT_DIRECTION_PARAMETER;
import static org.fed333.servletboot.web.binding.constants.ConstantParameters.SORT_PROPERTY_PARAMETER;
import static org.fed333.servletboot.web.binding.utils.BindingUtils.bindSort;
import static org.fed333.servletboot.web.binding.utils.BindingUtils.qualify;

/**
 * Designed for binding Sort object to controllers methods.
 * @author Roman Kovalchuk
 * @see Sort
 * @version 1.1
 * */
@SuppressWarnings("unused")
public class SortParameterBinder implements ParameterBinder {

    @Override
    public Object bindParameter(Parameter parameter, HttpServletRequest req, HttpServletResponse res, ApplicationContext context) {
        return bindSort(req, qualify(parameter, SORT_PROPERTY_PARAMETER.getName()) , qualify(parameter, SORT_DIRECTION_PARAMETER.getName()));
    }

    @Override
    public boolean matchesParameter(Parameter parameter) {
        return Sort.class.isAssignableFrom(parameter.getType());
    }
}