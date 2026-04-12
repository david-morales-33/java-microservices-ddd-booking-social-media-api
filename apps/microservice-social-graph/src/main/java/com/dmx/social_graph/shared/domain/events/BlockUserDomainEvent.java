package com.dmx.social_graph.shared.domain.events;


import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class BlockUserDomainEvent extends DomainEvent {
    private final String userBlockerId;
    private final String userBlockedId;

    public BlockUserDomainEvent(String aggregateId, String userBlockerId, String userBlockedId) {
        super(aggregateId);
        this.userBlockerId = userBlockerId;
        this.userBlockedId = userBlockedId;
    }

    public BlockUserDomainEvent(String aggregateId, String eventId, String occurredOn, String userBlockerId, String userBlockedId) {
        super(aggregateId, eventId, occurredOn);
        this.userBlockerId = userBlockerId;
        this.userBlockedId = userBlockedId;
    }

    public BlockUserDomainEvent() {
        super(null);
        this.userBlockedId = null;
        this.userBlockerId = null;
    }

    public String getUserBlockerId() {
        return userBlockerId;
    }

    public String getUserBlockedId() {
        return userBlockedId;
    }

    @Override
    public String eventName() {
        return "social.graph.block";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("userBlockedId", userBlockedId);
            put("userBlockerId", userBlockerId);
        }};
    }

    @Override
    public BlockUserDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new BlockUserDomainEvent(
                aggregateId,
                eventId,
                occurredOn
        );
    }
}
