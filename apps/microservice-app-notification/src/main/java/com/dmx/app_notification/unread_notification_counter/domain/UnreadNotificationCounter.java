package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.app_notification.notification.domain.UserId;

import java.util.Objects;

public final class UnreadNotificationCounter {
    private final UserId userId;
    private UnreadNotificationCount unreadCount;

    public UnreadNotificationCounter(UserId userId, UnreadNotificationCount unreadCount) {
        this.userId = userId;
        this.unreadCount = unreadCount != null ? unreadCount : UnreadNotificationCount.zero();
    }

    private UnreadNotificationCounter() {
        this.userId = null;
        this.unreadCount = null;
    }

    public static UnreadNotificationCounter create(UserId userId) {
        return new UnreadNotificationCounter(userId, UnreadNotificationCount.zero());
    }

    public UserId getUserId() {
        return userId;
    }

    public UnreadNotificationCount getUnreadCount() {
        return unreadCount;
    }

    public void increment() {
        this.unreadCount = this.unreadCount.increment();
    }

    public void decrement() {
        this.unreadCount = this.unreadCount.decrement();
    }

    public void reset() {
        this.unreadCount = UnreadNotificationCount.zero();
    }

    public UnreadNotificationCounterDTO toPrimitives() {
        return new UnreadNotificationCounterDTO(
                this.userId.value(),
                this.unreadCount.value()
        );
    }

    public static UnreadNotificationCounter fromPrimitives(UnreadNotificationCounterDTO dto) {
        return new UnreadNotificationCounter(
                new UserId(dto.userId()),
                new UnreadNotificationCount(dto.unreadCount())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnreadNotificationCounter that = (UnreadNotificationCounter) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
