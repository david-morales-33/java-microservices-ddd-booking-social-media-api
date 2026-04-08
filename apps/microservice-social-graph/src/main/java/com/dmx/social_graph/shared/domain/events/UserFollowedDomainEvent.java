package com.dmx.social_graph.shared.domain.events;

import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserFollowedDomainEvent extends DomainEvent {
    private final String followerId;
    private final String userId;

    public UserFollowedDomainEvent() {
        super(null);
        this.followerId = null;
        this.userId = null;
    }

    public UserFollowedDomainEvent(String aggregateId, String followerId, String userId) {
        super(aggregateId);
        this.followerId = followerId;
        this.userId = userId;
    }

    public UserFollowedDomainEvent(String aggregateId, String eventId, String occurredOn, String userId, String followerId) {
        super(aggregateId, eventId, occurredOn);
        this.followerId = followerId;
        this.userId = userId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public String getFollowedId() {
        return userId;
    }

    @Override
    public String eventName() {
        return "social.graph.follow";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("userId", userId);
            put("followerId", followerId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new UserFollowedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("userId"),
                (String) body.get("followerId")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserFollowedDomainEvent that = (UserFollowedDomainEvent) o;
        return followerId.equals(that.followerId) &&
                userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, userId);
    }
}
