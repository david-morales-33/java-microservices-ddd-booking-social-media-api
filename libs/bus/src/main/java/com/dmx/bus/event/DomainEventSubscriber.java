package com.dmx.bus.event;

public interface DomainEventSubscriber<T extends DomainEvent> {
    void on(T event);
    Class<T> subscribedTo();
}