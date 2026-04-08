package com.dmx.app_notification.notification.application.create_notification;

import com.dmx.bus.command.Command;

public final class CreateNotificationCommand implements Command {
    private final String recipientUserId;
    private final String sourceUserId;
    private final String type;
    private final String referenceId;

    public CreateNotificationCommand(String recipientUserId, String sourceUserId, String type, String referenceId) {
        this.recipientUserId = recipientUserId;
        this.sourceUserId = sourceUserId;
        this.type = type;
        this.referenceId = referenceId;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }

    public String getSourceUserId() {
        return sourceUserId;
    }

    public String getType() {
        return type;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
