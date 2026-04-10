package com.dmx.app_notification.shared.infrastructure.bus.command;

import com.dmx.bus.command.Command;
import com.dmx.bus.command.CommandBus;
import com.dmx.bus.command.CommandHandler;
import com.dmx.bus.command.CommandHandlerExecutionException;
import com.dmx.shared.kernel.Service;
import org.springframework.context.ApplicationContext;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final AppNotificationCommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(AppNotificationCommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionException {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionException(error);
        }
    }
}
