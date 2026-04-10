package com.dmx.app_notification.notification.application.new_notification_listened;

import com.dmx.app_notification.notification.domain.*;
import com.dmx.shared.kernel.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationCreator {
    private final NotificationRepository repository;

    public NotificationCreator(NotificationRepository repository) {
        this.repository = repository;
    }

    @Transactional("app_notification-transaction_manager")
    public void create(UserId recipientUserId, UserId sourceUserId, NotificationType type, ReferenceId referenceId) {
        Notification notification = Notification.create(recipientUserId, sourceUserId, type, referenceId);
        repository.save(notification);
    }
}
