package com.dmx.app_notification.shared.infrastructure.bus.event.inmemory;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationDomainEventSubscribersInformation;

import java.util.List;

@Service
public class InMemoryEventBus implements EventBus {

    private final AppNotificationDomainEventSubscribersInformation registry;

    public InMemoryEventBus(AppNotificationDomainEventSubscribersInformation registry) {
        this.registry = registry;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        System.out.println("Publishhhh...");
        for (DomainEvent event : events) {
            List<DomainEventSubscriber<?>> subscribers =
                    registry.search(event.eventName());

            for (DomainEventSubscriber subscriber : subscribers) {
                subscriber.on(event);
            }
        }
    }
}