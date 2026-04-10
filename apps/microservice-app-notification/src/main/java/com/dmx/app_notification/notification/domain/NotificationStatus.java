package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.StringValueObject;
import com.dmx.shared.kernel.ValueObjectException;

public final class NotificationStatus extends StringValueObject {

    private NotificationStatus() {
        super(null);
    }

    public NotificationStatus(String value) {
        super(value);
        Status status = Status.fromValue(value);
        if (status == null) {
            throw new ValueObjectException(String.format("Invalid notification status <%s>", value));
        }
    }

    public static NotificationStatus read() {
        return new NotificationStatus(Status.READ.value());
    }

    public static NotificationStatus unread() {
        return new NotificationStatus(Status.UNREAD.value());
    }

    public boolean isRead() {
        return this.value().equals(Status.READ.value());
    }

    public boolean isUnread() {
        return this.value().equals(Status.UNREAD.value());
    }
}
