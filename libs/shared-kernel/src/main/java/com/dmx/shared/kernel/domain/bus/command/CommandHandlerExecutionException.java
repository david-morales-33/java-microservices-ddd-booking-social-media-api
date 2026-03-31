package com.dmx.shared.kernel.domain.bus.command;

public final class CommandHandlerExecutionException extends RuntimeException {
    public CommandHandlerExecutionException(Throwable message) {
        super(message);
    }
}
