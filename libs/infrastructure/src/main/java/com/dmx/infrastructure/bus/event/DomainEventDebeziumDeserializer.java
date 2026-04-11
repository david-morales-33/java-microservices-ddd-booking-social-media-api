package com.dmx.infrastructure.bus.event;

import com.dmx.shared.kernel.events.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class DomainEventDebeziumDeserializer {
    protected abstract DomainEventsInformation getDomainEventsInformation();
    public DomainEvent deserialize(String message) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(message);
        JsonNode payload = root.get("payload");
        JsonNode body = payload.get("after");

        Class<? extends DomainEvent> domainEventClass = getDomainEventsInformation().forName((String) body.get("evt_name").asText());
        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();
        String eventBody = body.get("evt_body").asText();

        HashMap<String, Serializable> attributes = (HashMap<String, Serializable>) mapper.readValue(
                eventBody,
                new TypeReference<Map<String, Serializable>>() {
                }
        );

        Method fromPrimitivesMethod = domainEventClass.getMethod(
                "fromPrimitives",
                String.class,
                HashMap.class,
                String.class,
                String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
                nullInstance,
                (String) body.get("evt_aggregate_id").asText(),
                attributes,
                (String) body.get("evt_id").asText(),
                (String) body.get("evt_occurred_on").asText()
        );
        return (DomainEvent) domainEvent;
    }
}
