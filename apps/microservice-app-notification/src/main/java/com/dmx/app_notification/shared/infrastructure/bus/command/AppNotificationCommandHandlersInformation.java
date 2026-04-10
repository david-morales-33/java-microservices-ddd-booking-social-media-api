package com.dmx.app_notification.shared.infrastructure.bus.command;

import com.dmx.bus.command.Command;
import com.dmx.bus.command.CommandHandler;
import com.dmx.bus.command.CommandNotRegisteredException;
import com.dmx.infrastructure.bus.command.CommandHandlersInformation;
import com.dmx.shared.kernel.Service;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public final class AppNotificationCommandHandlersInformation extends CommandHandlersInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.app_notification";
    }
}
