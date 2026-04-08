package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.shared.kernel.DomainException;

public class UnreadNotificationCountNotValidException extends DomainException {
    public UnreadNotificationCountNotValidException() {
        super("UNREAD_NOTIFICATION_COUNT_NOT_VALID", "Illegal parameter exception");
    }
}
