package com.dmx.social_graph.shared.domain.events;


import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class BlockUserDomainEvent extends DomainEvent {

    public BlockUserDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    public BlockUserDomainEvent(String aggregateId, String eventId, String occurredOn) {
        super(aggregateId, eventId, occurredOn);
    }

    public BlockUserDomainEvent() {
    }

    @Override
    public String eventName() {
        return "user.blocked";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("aggregate_id", aggregateId());
            put("event_id", eventId());
            put("event_name", eventName());
            put("ocurred_on", occurredOn());

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
