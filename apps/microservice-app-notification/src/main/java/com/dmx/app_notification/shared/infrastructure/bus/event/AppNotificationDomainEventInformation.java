package com.dmx.app_notification.shared.infrastructure.bus.event;

import com.dmx.infrastructure.bus.event.DomainEventsInformation;

public class AppNotificationDomainEventInformation extends DomainEventsInformation {
    @Override
    protected String getPackageToScan() {
        return "com.dmx.app_notification";
    }
}
