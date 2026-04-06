package com.dmx.social_graph.shared.infrastructure.bus.event.outbox;

import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.events.OutboxEventRepository;

import java.util.List;

public final class OutboxEventBus implements EventBus {

    private final OutboxEventRepository repository;

    public OutboxEventBus(OutboxEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publish(List<DomainEvent> events) {
    }
}
