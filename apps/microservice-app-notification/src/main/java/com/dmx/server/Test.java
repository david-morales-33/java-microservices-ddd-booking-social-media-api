package com.dmx.server;

import com.dmx.app_notification.notification.domain.Status;
import com.dmx.app_notification.notification.domain.Type;
import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationDomainEventSubscribersInformation;

public class Test {
    public static void main(String[] args) {
        System.out.println(Type.BOOKING_CONFIRMED.value());
    }
}
