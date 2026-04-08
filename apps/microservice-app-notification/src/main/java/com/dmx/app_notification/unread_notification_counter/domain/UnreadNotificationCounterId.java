package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.shared.kernel.Identifier;

public final class UnreadNotificationCounterId extends Identifier {
    public UnreadNotificationCounterId(String value) {
        super(value);
    }

    private UnreadNotificationCounterId() {
    }

    public static UnreadNotificationCounterId of(String value) {
        return new UnreadNotificationCounterId(value);
    }
}

