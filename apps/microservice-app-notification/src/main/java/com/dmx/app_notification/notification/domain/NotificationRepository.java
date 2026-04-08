package com.dmx.app_notification.notification.domain;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    void save(Notification notification);
    Optional<Notification> find(NotificationId notificationId);
    List<Notification> search(UserId id);
}
