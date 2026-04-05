package com.dmx.shared.kernel.events;

public class OutboxEvent {
    private final String id;
    private final String aggregateId;
    private final String eventName;
    private final String body;
    private final String occurredOn;
    private final boolean published;

    public OutboxEvent(String id, String aggregateId, String eventName, String body, String occurredOn, boolean published) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.eventName = eventName;
        this.body = body;
        this.occurredOn = occurredOn;
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getBody() {
        return body;
    }

    public String getOccurredOn() {
        return occurredOn;
    }

    public boolean isPublished() {
        return published;
    }
}
