package com.dmx.app_notification.unread_notification_counter.application.decrement;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.shared.domain.events.NotificationReadDomainEvent;
import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;

@Service
public class DecrementCounterOnNotificationRead implements DomainEventSubscriber<NotificationReadDomainEvent> {
    private final UnreadNotificationCounterDecrementer decrementer;

    public DecrementCounterOnNotificationRead(UnreadNotificationCounterDecrementer decrementer) {
        this.decrementer = decrementer;
    }

    @Override
    public Class<NotificationReadDomainEvent> subscribedTo() {
        return NotificationReadDomainEvent.class;
    }

    @Override
    public void on(NotificationReadDomainEvent event) {
        UserId userId = new UserId(event.toPrimitives().get("recipientId").toString());
        decrementer.decrement(userId);
    }
}
