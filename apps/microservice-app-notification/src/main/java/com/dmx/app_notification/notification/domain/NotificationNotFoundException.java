package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.DomainException;

public class NotificationNotFoundException extends DomainException {
    public NotificationNotFoundException(NotificationId id) {
        super("NOTIFICATION_NOT_FOUND", String.format("The notification <%s> not found", id.value()));
    }
}
