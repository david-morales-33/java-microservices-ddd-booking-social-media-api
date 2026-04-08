package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.DomainException;

public class NotifyThemselvesException extends DomainException {
    public NotifyThemselvesException() {
        super("NOTIFY_THEMSELVES_EXCEPTION", "The ID's sender and receiver are the same");
    }
}
