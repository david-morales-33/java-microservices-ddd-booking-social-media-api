package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.shared.kernel.IntValueObject;

public final class UnreadNotificationCount extends IntValueObject {
    public UnreadNotificationCount(int value) {
        super(value);
        if (this.isNegative(value)) {
            throw new UnreadNotificationCountNotValidException();
        }
    }

    private UnreadNotificationCount() {
        super(0);
    }

    public static UnreadNotificationCount zero() {
        return new UnreadNotificationCount(0);
    }

    public static UnreadNotificationCount of(int value) {
        return new UnreadNotificationCount(value);
    }

    public UnreadNotificationCount increment() {
        return new UnreadNotificationCount(this.value() + 1);
    }

    public UnreadNotificationCount decrement() {
        if (this.value() <= 0) {
            return UnreadNotificationCount.zero();
        }
        return new UnreadNotificationCount(this.value() - 1);
    }

    private boolean isNegative(int value) {
        return value < 0;
    }
}

