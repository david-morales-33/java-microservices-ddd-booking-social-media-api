package com.dmx.app_notification.notification.application.find_unread_notifications;

import com.dmx.app_notification.notification.domain.Notification;
import com.dmx.app_notification.notification.domain.NotificationRepository;
import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.shared.kernel.Service;

import java.util.List;

@Service
public class UnreadNotificationFinder {
    private final NotificationRepository repository;

    public UnreadNotificationFinder(NotificationRepository repository) {
        this.repository = repository;
    }

    List<Notification> execute(UserId id) {
        return repository.search(id);
    }
}
