package com.dmx.app_notification.notification.application.find_unread_notifications;

import com.dmx.app_notification.notification.domain.Notification;
import com.dmx.app_notification.notification.domain.NotificationDTO;
import com.dmx.bus.query.Response;

import java.io.Serializable;
import java.util.List;

public final class UnreadNotificationResponse implements Response, Serializable {
    private final List<NotificationDTO> notificationsList;

    public UnreadNotificationResponse(List<Notification> notifications) {
        this.notificationsList = notifications.stream().map(Notification::toPrimitives).toList();
    }

    public List<NotificationDTO> getNotificationsList() {
        return notificationsList;
    }
}
