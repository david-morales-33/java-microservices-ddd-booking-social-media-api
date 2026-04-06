package com.dmx.shared.kernel.events;

import com.dmx.shared.kernel.Utils;

import java.sql.Timestamp;
import java.time.Instant;

public class OutboxEvent {
    private String id;
    private String aggregateId;
    private String eventName;
    private String body;
    private Timestamp occurredOn;

    public OutboxEvent(String id, String aggregateId, String eventName, String body, Timestamp occurredOn) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.eventName = eventName;
        this.body = body;
        this.occurredOn = occurredOn;
    }

    public static OutboxEvent fromDomainEvent(DomainEvent event) {
        return new OutboxEvent(
                event.eventId(),
                event.aggregateId(),
                event.eventName(),
                Utils.jsonEncode(event.toPrimitives()),
                Timestamp.from((Instant.parse((event.occurredOn()))))
        );
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

}
