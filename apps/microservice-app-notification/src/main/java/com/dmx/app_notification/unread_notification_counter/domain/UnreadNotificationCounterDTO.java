package com.dmx.app_notification.unread_notification_counter.domain;

import java.io.Serializable;

public record UnreadNotificationCounterDTO(
        String userId,
        Integer count
) implements Serializable {
}

