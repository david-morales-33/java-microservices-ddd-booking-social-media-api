package com.dmx.social_graph.shared.infrastructure.bus.event;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.shared.kernel.events.DomainEvent;

import java.util.List;

@Service
public final class SocialGraphSubscribersHandler {
    private final SocialGraphDomainEventSubscribersInformation information;

    public SocialGraphSubscribersHandler(SocialGraphDomainEventSubscribersInformation information) {
        this.information = information;
    }

    public void handle(DomainEvent event) {
        List<DomainEventSubscriber<?>> subscribers = information.search(event.eventName());
        for (DomainEventSubscriber subscriber : subscribers) {
            subscriber.on(event);
        }
    }
}
