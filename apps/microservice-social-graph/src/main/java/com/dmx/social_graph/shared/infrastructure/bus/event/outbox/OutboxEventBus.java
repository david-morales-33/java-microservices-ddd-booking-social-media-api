package com.dmx.social_graph.shared.infrastructure.bus.event.outbox;

import com.dmx.bus.event.DomainEvent;
import com.dmx.bus.event.EventBus;
import com.dmx.bus.event.OutboxRepository;

import java.util.List;

public final class OutboxEventBus implements EventBus {

    private final OutboxRepository repository;

    public OutboxEventBus(OutboxRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(repository::save);
    }
}
