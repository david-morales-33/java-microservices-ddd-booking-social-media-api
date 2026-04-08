package com.dmx.app_notification.notification.application.create_notification;

import com.dmx.app_notification.notification.domain.*;
import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;

@Service
public class NotificationCreator {
    private final NotificationRepository repository;
    private final EventBus bus;

    public NotificationCreator(NotificationRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public void create(UserId recipientUserId, UserId sourceUserId, NotificationType type, ReferenceId referenceId) {
        Notification notification = Notification.create(recipientUserId, sourceUserId, type, referenceId);

        repository.save(notification);
        bus.publish(notification.pullDomainEvents());
    }
}
