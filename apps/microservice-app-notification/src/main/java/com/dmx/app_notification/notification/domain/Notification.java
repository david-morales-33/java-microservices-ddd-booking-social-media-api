package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.AggregateRoot;
import com.dmx.shared.kernel.ValueObjectException;

import java.util.Objects;

public final class Notification extends AggregateRoot {
    private final NotificationId id;
    private final UserId recipientUserId;
    private final UserId sourceUserId;
    private final NotificationType type;
    private NotificationStatus status;
    private final ReferenceId referenceId;
    private final NotificationInstant createdAt;
    private NotificationInstant readAt;

    public Notification(NotificationId id, UserId recipientUserId, UserId sourceUserId,
                        NotificationType type, NotificationStatus status, ReferenceId referenceId,
                        NotificationInstant createdAt, NotificationInstant readAt) {
        if(recipientUserId.equals(sourceUserId)){
            throw new NotifyThemselvesException();
        }
        this.id = id;
        this.recipientUserId = recipientUserId;
        this.sourceUserId = sourceUserId;
        this.type = type;
        this.status = status;
        this.referenceId = referenceId;
        this.createdAt = createdAt;
        this.readAt = readAt;
    }

    private Notification() {
        this.id = null;
        this.recipientUserId = null;
        this.sourceUserId = null;
        this.type = null;
        this.status = null;
        this.referenceId = null;
        this.createdAt = null;
        this.readAt = null;
    }

    public static Notification create(UserId recipientUserId, UserId sourceUserId,
                                     NotificationType type, ReferenceId referenceId) {
        NotificationId notificationId = new NotificationId(NotificationId.generate());
        return new Notification(
                notificationId,
                recipientUserId,
                sourceUserId,
                type,
                NotificationStatus.UNREAD,
                referenceId,
                NotificationInstant.now(),
                null
        );
    }

    public NotificationId getId() {
        return id;
    }

    public UserId getRecipientUserId() {
        return recipientUserId;
    }

    public UserId getSourceUserId() {
        return sourceUserId;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public ReferenceId getReferenceId() {
        return referenceId;
    }

    public NotificationInstant getCreatedAt() {
        return createdAt;
    }

    public NotificationInstant getReadAt() {
        return readAt;
    }

    public void markAsRead() {
        if(status!= NotificationStatus.READ){
            this.status = NotificationStatus.READ;
            this.readAt = NotificationInstant.now();

        }
    }

    public void mute() {
        this.status = NotificationStatus.MUTED;
    }

    public NotificationDTO toPrimitives() {
        return new NotificationDTO(
                this.id.value(),
                this.recipientUserId.value(),
                this.sourceUserId.value(),
                this.type.name(),
                this.status.name(),
                this.referenceId.value(),
                this.createdAt.value().toString(),
                this.readAt != null ? this.readAt.value().toString() : null
        );
    }

    public static Notification fromPrimitives(NotificationDTO dto) {
        return new Notification(
                new NotificationId(dto.id()),
                new UserId(dto.recipientUserId()),
                new UserId(dto.sourceUserId()),
                NotificationType.valueOf(dto.type()),
                NotificationStatus.valueOf(dto.status()),
                new ReferenceId(dto.referenceId()),
                new NotificationInstant(java.sql.Timestamp.valueOf(dto.createdAt())),
                dto.readAt() != null ? new NotificationInstant(java.sql.Timestamp.valueOf(dto.readAt())) : null
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
