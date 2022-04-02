package org.fed333.servletboot.web;

import org.fed333.servletboot.annotation.Controller;
import org.fed333.servletboot.dispatcher.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Part of web transporting data layer between servlet's Command and Controller classes. <br>
 * Contains data to transfer from Controller into HttpServletRequest.
 * @see Controller
 * @see Command
 * @see HttpServletRequest
 * @author Roman Kovalchuk
 * @version 1.1
 * */
public interface Model {

    void addAttribute(String attribute, Object value);

    Object getAttribute(String attribute);

    Model mergeAttributes(Map<String, ?> toMerge);

    boolean containsAttribute(String attribute);

    Map<String, Object> asMap();
}
