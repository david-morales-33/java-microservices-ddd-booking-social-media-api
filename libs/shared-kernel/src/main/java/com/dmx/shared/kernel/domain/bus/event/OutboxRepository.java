package com.dmx.shared.kernel.domain.bus.event;

import java.util.List;

public interface OutboxRepository {
    void save(DomainEvent event);
    List<DomainEvent> findUnpublished(int limit);
    void markAsPublished(String eventId);
    void incrementRetries(String eventId);
}
