package com.dmx.social_graph.shared.infrastructure.bus.event.inmemory;

import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.shared.infrastructure.bus.event.DomainEventSubscribersInformation;

import java.util.List;

@Service
public class InMemoryEventBus implements EventBus {

    private final DomainEventSubscribersInformation registry;

    public InMemoryEventBus(DomainEventSubscribersInformation registry) {
        this.registry = registry;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        for (DomainEvent event : events) {
            List<DomainEventSubscriber<?>> subscribers = registry.search(event.eventName());
            for (DomainEventSubscriber subscriber : subscribers) {
                subscriber.on(event);
            }
        }
    }
}