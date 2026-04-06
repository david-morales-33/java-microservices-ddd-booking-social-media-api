package com.dmx.shared.kernel.events;

import java.sql.Timestamp;

public class OutboxEvent {
    private String id;
    private String aggregateId;
    private String eventName;
    private String body;
    private Timestamp occurredOn;
    private boolean published;

    public OutboxEvent(String id, String aggregateId, String eventName, String body, Timestamp occurredOn, boolean published) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.eventName = eventName;
        this.body = body;
        this.occurredOn = occurredOn;
        this.published = published;
    }

    protected OutboxEvent() {
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

    public Timestamp getOccurredOn() {
        return occurredOn;
    }

    public boolean isPublished() {
        return published;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setOccurredOn(Timestamp occurredOn) {
        this.occurredOn = occurredOn;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
