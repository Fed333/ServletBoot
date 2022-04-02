package org.fed333.servletboot.web.redirect;

import java.util.Map;

/**
 * Contains data to redirect.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public interface RedirectAttributes {

    RedirectAttributes addFlashAttribute(String attribute, Object value);

    Map<String, Object> getFlashAttributes();
}
