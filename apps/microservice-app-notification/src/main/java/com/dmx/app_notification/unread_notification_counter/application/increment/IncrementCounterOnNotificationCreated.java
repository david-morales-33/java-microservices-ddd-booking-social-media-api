package com.dmx.app_notification.unread_notification_counter.application.increment;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.shared.domain.events.NotificationCreatedDomainEvent;
import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;

@Service
public final class IncrementCounterOnNotificationCreated implements DomainEventSubscriber<NotificationCreatedDomainEvent> {

    private final UnreadNotificationCounterIncrementer incrementer;

    public IncrementCounterOnNotificationCreated(UnreadNotificationCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @Override
    public Class<NotificationCreatedDomainEvent> subscribedTo() {
        return NotificationCreatedDomainEvent.class;
    }

    @Override
    public void on(NotificationCreatedDomainEvent event) {
        UserId recipientId = UserId.of(event.toPrimitives().get("recipientId").toString());
        incrementer.increment(recipientId);
    }
}
