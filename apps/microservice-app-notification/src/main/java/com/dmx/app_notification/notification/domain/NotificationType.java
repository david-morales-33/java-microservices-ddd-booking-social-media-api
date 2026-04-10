package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.StringValueObject;
import com.dmx.shared.kernel.ValueObjectException;

public final class NotificationType extends StringValueObject {

    public NotificationType(String value) {
        super(value);
        if (Type.fromValue(value) == null) {
            throw new ValueObjectException(String.format("Invalid notification type <%s>", value));
        };
    }

    public NotificationType() {
        super(null);
    }

    public static NotificationType follow() {
        return new NotificationType(Type.NEW_FOLLOWER.value());
    }

    public static NotificationType booking() {
        return new NotificationType(Type.BOOKING_CONFIRMED.value());
    }

    public static NotificationType message() {
        return new NotificationType(Type.NEW_MESSAGE.value());
    }

    public static NotificationType Review() {
        return new NotificationType(Type.NEW_REVIEW.value());
    }

    public static NotificationType like() {
        return new NotificationType(Type.NEW_LIKE.value());
    }

    public static NotificationType comment() {
        return new NotificationType(Type.NEW_COMMENT.value());
    }
}
