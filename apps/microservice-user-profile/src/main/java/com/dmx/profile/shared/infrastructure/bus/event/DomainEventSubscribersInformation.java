package com.dmx.profile.shared.infrastructure.bus.event;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;

import java.util.*;

@Service
public final class DomainEventSubscribersInformation {
    private final Map<String, List<DomainEventSubscriber<?>>> subscribers = new HashMap<>();

    public DomainEventSubscribersInformation(List<DomainEventSubscriber<?>> subscribersList) {
        for (DomainEventSubscriber<?> subscriber : subscribersList) {

            Class<? extends DomainEvent> eventClass = subscriber.subscribedTo();
            String eventName = getEventName(eventClass);

            this.subscribers
                    .computeIfAbsent(eventName, k -> new ArrayList<>())
                    .add(subscriber);
        }
    }

    private String getEventName(Class<? extends DomainEvent> eventClass) {
        try {
            return eventClass
                    .getDeclaredConstructor()
                    .newInstance()
                    .eventName();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate event: " + eventClass.getName(), e);
        }
    }

    public List<DomainEventSubscriber<?>> search(String eventName) {
        return subscribers.getOrDefault(eventName, Collections.emptyList());
    }
}
