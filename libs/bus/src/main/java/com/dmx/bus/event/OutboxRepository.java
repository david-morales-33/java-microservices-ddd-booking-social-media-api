package com.dmx.bus.event;

import com.dmx.shared.kernel.events.DomainEvent;

import java.util.List;

public interface OutboxRepository {
    void save(DomainEvent event);
    List<DomainEvent> findUnpublished(int limit);
    void markAsPublished(String eventId);
    void incrementRetries(String eventId);
}
