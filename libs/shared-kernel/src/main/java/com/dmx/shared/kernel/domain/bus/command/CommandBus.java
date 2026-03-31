package com.dmx.shared.kernel.domain.bus.command;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionException;
}
