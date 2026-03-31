package com.dmx.shared.kernel.domain.bus.event;

public interface DomainEventSubscriber<T extends DomainEvent> {
    void on(T event);
    Class<T> subscribedTo();
}