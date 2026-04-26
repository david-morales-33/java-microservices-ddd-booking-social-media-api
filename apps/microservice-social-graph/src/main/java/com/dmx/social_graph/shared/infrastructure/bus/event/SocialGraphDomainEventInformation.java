package com.dmx.social_graph.shared.infrastructure.bus.event;

import com.dmx.infrastructure.bus.event.DomainEventsInformation;
import com.dmx.shared.kernel.Service;

@Service
public class SocialGraphDomainEventInformation extends DomainEventsInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.social_graph";
    }
}
