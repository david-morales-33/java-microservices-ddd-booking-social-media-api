package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.app_notification.notification.domain.UserId;

public interface UnreadNotificationCounterRepository {
    void increment(UserId userId);
    void decrement(UserId userId);
    void getCount(UserId userId);
}
