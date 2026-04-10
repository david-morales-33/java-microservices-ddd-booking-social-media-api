package com.dmx.app_notification.shared.infrastructure.bus.event;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;

import java.util.List;

@Service
public final class AppNotificationSubscribersHandler {
    private final AppNotificationDomainEventSubscribersInformation information;

    public AppNotificationSubscribersHandler(AppNotificationDomainEventSubscribersInformation information) {
        this.information = information;
    }

    public void handle(DomainEvent event) {
        List<DomainEventSubscriber<?>> subscribers = information.search(event.eventName());
        for (DomainEventSubscriber subscriber : subscribers) {
            subscriber.on(event);
        }
    }
}
