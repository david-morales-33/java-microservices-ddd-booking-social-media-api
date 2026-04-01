package com.dmx.bus.event;
import com.dmx.shared.kernel.events.DomainEvent;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
