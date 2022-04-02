package org.fed333.servletboot.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Based on HashMap implementation of Model interface.
 * @see Model
 * @see HashMap
 * @author Roman Kovalchuk
 * @version 1.1
 * */
@SuppressWarnings("unused")
public class WebModel implements Model {

    private final Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String attribute, Object value) {
        map.put(attribute, value);
    }

    @Override
    public Object getAttribute(String attribute) {
        return map.get(attribute);
    }

    @Override
    public Model mergeAttributes(Map<String, ?> toMerge) {
        map.putAll(toMerge);
        return this;
    }

    @Override
    public boolean containsAttribute(String attribute) {
        return map.containsKey(attribute);
    }

    @Override
    public Map<String, Object> asMap() {
        return map;
    }
}
