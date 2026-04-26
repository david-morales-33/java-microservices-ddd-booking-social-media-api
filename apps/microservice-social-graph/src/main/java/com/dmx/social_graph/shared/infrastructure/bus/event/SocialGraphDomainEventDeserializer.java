package com.dmx.social_graph.shared.infrastructure.bus.event;

import com.dmx.infrastructure.bus.event.DomainEventDebeziumDeserializer;
import com.dmx.infrastructure.bus.event.DomainEventsInformation;
import com.dmx.shared.kernel.Service;

@Service
public class SocialGraphDomainEventDeserializer extends DomainEventDebeziumDeserializer {
    private final SocialGraphDomainEventInformation eventInformation;

    public SocialGraphDomainEventDeserializer(SocialGraphDomainEventInformation eventInformation) {
        this.eventInformation = eventInformation;
    }
    @Override
    protected DomainEventsInformation getDomainEventsInformation() {
        return eventInformation;
    }
}
