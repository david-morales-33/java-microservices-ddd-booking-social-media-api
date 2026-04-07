package com.dmx.app_notification.notification.domain;

import java.io.Serializable;

public record NotificationDTO(
        String id,
        String recipientUserId,
        String sourceUserId,
        String type,
        String status,
        String referenceId,
        String createdAt,
        String readAt
) implements Serializable {
}

