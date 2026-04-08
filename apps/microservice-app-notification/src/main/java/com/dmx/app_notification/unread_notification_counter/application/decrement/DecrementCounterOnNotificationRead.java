package com.dmx.app_notification.unread_notification_counter.application.decrement;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.shared.domain.events.NotificationReadDomainEvent;
import com.dmx.shared.kernel.EventHandler;

@EventHandler
public class DecrementCounterOnNotificationRead {
    private final UnreadNotificationCounterDecrementer decrementer;

    public DecrementCounterOnNotificationRead(UnreadNotificationCounterDecrementer decrementer) {
        this.decrementer = decrementer;
    }

    public void on(NotificationReadDomainEvent event) {
        UserId userId = new UserId(event.getUserId());
        decrementer.decrement(userId);
    }
}
