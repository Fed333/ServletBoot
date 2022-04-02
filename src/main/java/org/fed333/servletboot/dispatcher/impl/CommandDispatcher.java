package org.fed333.servletboot.dispatcher.impl;

import org.fed333.servletboot.annotation.FetchCommands;
import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.dispatcher.Command;
import org.fed333.servletboot.dispatcher.DispatcherCommand;
import org.fed333.servletboot.dispatcher.HttpMethod;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Base implementation of DispatcherCommand interface.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton
public final class CommandDispatcher implements DispatcherCommand {

    @FetchCommands
    private Map<SimpleImmutableEntry<String, HttpMethod>, AtomicReference<Command>> commands;

    @Override
    public Command getCommand(String url, HttpMethod method){
        return commands.get(new SimpleImmutableEntry<>(url, method)).get();
    }
}
