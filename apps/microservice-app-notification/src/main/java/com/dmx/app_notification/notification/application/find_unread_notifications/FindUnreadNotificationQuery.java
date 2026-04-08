package com.dmx.app_notification.notification.application.find_unread_notifications;

import com.dmx.bus.query.Query;

public final class FindUnreadNotificationQuery implements Query {
    private final String recipientUserId;

    public FindUnreadNotificationQuery(String recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }
}
