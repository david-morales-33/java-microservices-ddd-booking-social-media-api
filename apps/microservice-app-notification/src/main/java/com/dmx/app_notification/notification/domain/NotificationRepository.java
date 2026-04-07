package com.dmx.app_notification.notification.domain;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> find(NotificationId notificationId);
    List<Notification> search(RecipientUserId userId);
}
