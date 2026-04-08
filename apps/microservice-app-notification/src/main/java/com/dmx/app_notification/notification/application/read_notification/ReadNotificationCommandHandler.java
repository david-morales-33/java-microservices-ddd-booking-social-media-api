package com.dmx.app_notification.notification.application.read_notification;

import com.dmx.app_notification.notification.domain.NotificationId;
import com.dmx.bus.command.CommandHandler;
import com.dmx.shared.kernel.Service;

@Service
public final class ReadNotificationCommandHandler implements CommandHandler<ReadNotificationCommand> {

    private final NotificationReader reader;

    public ReadNotificationCommandHandler(NotificationReader reader) {
        this.reader = reader;
    }

    @Override
    public void handle(ReadNotificationCommand command) {
        NotificationId id = NotificationId.of(command.getNotificationId());
        reader.execute(id);
    }
}
