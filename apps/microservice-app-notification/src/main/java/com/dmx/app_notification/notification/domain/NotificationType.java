package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.ValueObjectException;

public final class NotificationType {
    private final Type value;

    public NotificationType(String value) {
        if (Type.fromValue(value) == null) {
            throw new ValueObjectException(String.format("Invalid notification type <%s>", value));
        }
        this.value = Type.fromValue(value);
    }

    public NotificationType(Type value) {
        this.value = value;
    }

    public String value() {
        return value.value();
    }

    public NotificationType() {
        value = null;
    }

    public static NotificationType follow() {
        return new NotificationType(Type.NEW_FOLLOWER);
    }

    public static NotificationType booking() {
        return new NotificationType(Type.BOOKING_CONFIRMED);
    }

    public static NotificationType message() {
        return new NotificationType(Type.NEW_MESSAGE);
    }

    public static NotificationType Review() {
        return new NotificationType(Type.NEW_REVIEW);
    }

    public static NotificationType like() {
        return new NotificationType(Type.NEW_LIKE);
    }

    public static NotificationType comment() {
        return new NotificationType(Type.NEW_COMMENT);
    }
}
