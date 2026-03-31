package com.dmx.shared.kernel.domain.bus.command;

public final class CommandNotRegisteredException extends Exception {
    public CommandNotRegisteredException(Class<? extends Command> command) {
      super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
    }
}
