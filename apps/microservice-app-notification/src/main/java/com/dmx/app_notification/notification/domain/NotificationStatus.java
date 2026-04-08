package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.ValueObjectException;

public final class NotificationStatus {

    private final Status value;

    private NotificationStatus() {
        value = null;
    }

    private NotificationStatus(Status value) {
        this.value = value;
    }

    public NotificationStatus(String value) {
        Status status = Status.fromValue(value);
        if (status == null) {
            throw new ValueObjectException(String.format("Invalid notification status <%s>", value));
        }
        this.value = status;
    }

    public static NotificationStatus read() {
        return new NotificationStatus(Status.READ);
    }

    public static NotificationStatus unread() {
        return new NotificationStatus(Status.UNREAD);
    }

    public String value() {
        return value.value();
    }

    public boolean isRead() {
        return value == Status.READ;
    }

    public boolean isUnread() {
        return value == Status.UNREAD;
    }
}
