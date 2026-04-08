package com.dmx.app_notification.shared.domain.events;

import com.dmx.shared.kernel.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class NotificationReadDomainEvent extends DomainEvent {
    private final String notificationId;
    private final String userId;
    private final LocalDateTime occurredOn;

    public NotificationReadDomainEvent(String notificationId, String userId) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.occurredOn = LocalDateTime.now();
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationReadDomainEvent that = (NotificationReadDomainEvent) o;
        return Objects.equals(notificationId, that.notificationId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, userId);
    }
}
