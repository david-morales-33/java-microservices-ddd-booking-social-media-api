package com.dmx.bus.command;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionException;
}
