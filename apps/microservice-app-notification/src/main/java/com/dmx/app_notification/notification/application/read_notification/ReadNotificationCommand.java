package com.dmx.app_notification.notification.application.read_notification;

import com.dmx.bus.command.Command;

public final class ReadNotificationCommand implements Command {
    private final String notificationId;

    public ReadNotificationCommand(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationId() {
        return notificationId;
    }
}
