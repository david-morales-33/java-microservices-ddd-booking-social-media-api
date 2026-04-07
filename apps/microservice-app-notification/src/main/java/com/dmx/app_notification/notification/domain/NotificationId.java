package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.Identifier;

public final class NotificationId extends Identifier {
    public NotificationId(String value) {
        super(value);
    }

    private NotificationId() {
    }

    public static NotificationId of(String value) {
        return new NotificationId(value);
    }
}

