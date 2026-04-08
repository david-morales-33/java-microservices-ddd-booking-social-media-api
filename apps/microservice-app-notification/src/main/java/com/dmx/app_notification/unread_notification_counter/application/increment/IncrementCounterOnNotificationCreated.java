package com.dmx.app_notification.unread_notification_counter.application.increment;

import com.dmx.app_notification.notification.domain.UserId;
import com.dmx.app_notification.shared.domain.events.CreateNotificationEvent;
import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;

@Service
public final class IncrementCounterOnNotificationCreated implements DomainEventSubscriber<CreateNotificationEvent> {

    private final UnreadNotificationCounterIncrementer incrementer;

    public IncrementCounterOnNotificationCreated(UnreadNotificationCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @Override
    public Class<CreateNotificationEvent> subscribedTo() {
        return CreateNotificationEvent.class;
    }

    @Override
    public void on(CreateNotificationEvent event) {
        UserId recipientId = UserId.of(event.toPrimitives().get("recipientId").toString());
        incrementer.increment(recipientId);
    }
}
