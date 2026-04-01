package com.dmx.bus.command;

public interface CommandHandler <T extends Command>{
    void handle(T command);
}
