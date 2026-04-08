package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.app_notification.notification.domain.UserId;

import java.util.Optional;

public interface UnreadNotificationCounterRepository {
    void save(UnreadNotificationCounter counter);
    Optional<UnreadNotificationCounter> find(UserId userId);
}
