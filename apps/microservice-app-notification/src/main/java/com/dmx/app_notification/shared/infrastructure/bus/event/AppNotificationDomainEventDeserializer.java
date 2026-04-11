package com.dmx.app_notification.shared.infrastructure.bus.event;

import com.dmx.infrastructure.bus.event.DomainEventDebeziumDeserializer;
import com.dmx.infrastructure.bus.event.DomainEventsInformation;

public class AppNotificationDomainEventDeserializer extends DomainEventDebeziumDeserializer {
    @Override
    protected DomainEventsInformation getDomainEventsInformation() {
        return new AppNotificationDomainEventInformation();
    }
}
