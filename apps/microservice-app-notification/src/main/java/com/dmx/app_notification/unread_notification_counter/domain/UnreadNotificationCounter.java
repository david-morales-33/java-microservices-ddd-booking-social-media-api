package com.dmx.app_notification.unread_notification_counter.domain;

import com.dmx.app_notification.notification.domain.UserId;

import java.util.Objects;

public final class UnreadNotificationCounter {
    private final UserId userId;
    private UnreadNotificationCount count;

    public UnreadNotificationCounter(UserId userId, UnreadNotificationCount count) {
        this.userId = userId;
        this.count = count != null ? count : UnreadNotificationCount.zero();
    }

    private UnreadNotificationCounter() {
        this.userId = null;
        this.count = null;
    }

    public static UnreadNotificationCounter create(UserId userId) {
        return new UnreadNotificationCounter(userId, UnreadNotificationCount.zero());
    }

    public UserId getUserId() {
        return userId;
    }

    public UnreadNotificationCount getUnreadCount() {
        return count;
    }

    public void increment() {
        this.count = this.count.increment();
    }

    public void decrement() {
        this.count = this.count.decrement();
    }

    public void reset() {
        this.count = UnreadNotificationCount.zero();
    }

    public UnreadNotificationCounterDTO toPrimitives() {
        return new UnreadNotificationCounterDTO(
                this.userId.value(),
                this.count.value()
        );
    }

    public static UnreadNotificationCounter fromPrimitives(UnreadNotificationCounterDTO dto) {
        return new UnreadNotificationCounter(
                new UserId(dto.userId()),
                new UnreadNotificationCount(dto.count())
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
