package org.fed333.servletboot.annotation;

import org.fed333.servletboot.dispatcher.Command;
import org.fed333.servletboot.configurator.DispatcherCommandInterfaceObjectConfigurator;
import org.fed333.servletboot.dispatcher.DispatcherCommand;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks attribute place in DispatcherCommand for storing http mapping with Commands objects.<br>
 * The annotated field must be assignable to Map.
 * The only presence in DispatcherCommand class is allowed.<br>
 * Occurs in DispatcherCommandInterfaceObjectConfiguration in garbage all dispatched Commands inside the storage.
 * @see Command
 * @see DispatcherCommand
 * @see DispatcherCommandInterfaceObjectConfigurator
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FetchCommands {
}
