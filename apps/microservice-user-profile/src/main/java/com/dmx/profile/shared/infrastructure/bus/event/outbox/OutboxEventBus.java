package com.dmx.profile.shared.infrastructure.bus.event.outbox;

import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.shared.kernel.events.OutboxEvent;
import com.dmx.shared.kernel.events.OutboxEventRepository;

import java.util.List;

@Service
public final class OutboxEventBus implements EventBus {

    private final OutboxEventRepository repository;

    public OutboxEventBus(OutboxEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(event -> {
            repository.save(OutboxEvent.fromDomainEvent(event));
        });
    }
}
