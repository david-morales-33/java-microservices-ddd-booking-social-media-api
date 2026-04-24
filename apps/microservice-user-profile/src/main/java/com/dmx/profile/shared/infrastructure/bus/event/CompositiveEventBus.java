package com.dmx.social_graph.shared.infrastructure.bus.event;

import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.social_graph.shared.infrastructure.bus.event.inmemory.InMemoryEventBus;
import com.dmx.social_graph.shared.infrastructure.bus.event.outbox.OutboxEventBus;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
@Service
public class CompositiveEventBus implements EventBus {
    private final InMemoryEventBus inMemoryEventBus;
    private final OutboxEventBus outboxEventBus;

    public CompositiveEventBus(InMemoryEventBus inMemoryEventBus, OutboxEventBus outboxEventBus) {
        this.inMemoryEventBus = inMemoryEventBus;
        this.outboxEventBus = outboxEventBus;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        inMemoryEventBus.publish(events);
        outboxEventBus.publish(events);
    }
}
