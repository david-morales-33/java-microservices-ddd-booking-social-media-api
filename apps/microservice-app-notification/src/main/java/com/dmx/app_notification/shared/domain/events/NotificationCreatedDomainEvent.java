package com.dmx.app_notification.shared.domain.events;

import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CreateNotificationEvent extends DomainEvent {
    private final String recipientUserId;
    private final String sourceUserId;

    public CreateNotificationEvent(String aggregateId, String recipientUserId, String sourceUserId) {
        super(aggregateId);
        this.recipientUserId = recipientUserId;
        this.sourceUserId = sourceUserId;
    }

    public CreateNotificationEvent(String aggregateId, String eventId, String occurredOn, String recipientUserId, String sourceUserId) {
        super(aggregateId, eventId, occurredOn);
        this.recipientUserId = recipientUserId;
        this.sourceUserId = sourceUserId;
    }

    public CreateNotificationEvent(String recipientUserId, String sourceUserId) {
        this.recipientUserId = recipientUserId;
        this.sourceUserId = sourceUserId;
    }

    @Override
    public String eventName() {
        return "app.notification.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("recipientUser", recipientUserId);
            put("sourceUser", sourceUserId);
        }};
    }

    @Override
    public CreateNotificationEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CreateNotificationEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("recipientUser"),
                (String) body.get("sourceUser")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateNotificationEvent that = (CreateNotificationEvent) o;
        return recipientUserId.equals(that.recipientUserId) &&
                sourceUserId.equals(that.sourceUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientUserId, sourceUserId);
    }
}
