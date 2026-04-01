package com.dmx.bus.event;

import com.dmx.shared.kernel.events.DomainEvent;

public interface DomainEventSubscriber<T extends DomainEvent> {
    void on(T event);
    Class<T> subscribedTo();
}