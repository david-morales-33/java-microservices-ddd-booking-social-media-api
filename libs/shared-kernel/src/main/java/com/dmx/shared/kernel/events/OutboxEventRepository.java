package com.dmx.shared.kernel.events;

import java.util.List;

public interface OutboxEventRepository {
    void save(OutboxEvent event);
    List<OutboxEvent> findUnpublished();
}
