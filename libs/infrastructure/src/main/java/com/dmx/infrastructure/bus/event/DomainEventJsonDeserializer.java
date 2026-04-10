package com.dmx.infrastructure.bus.event;

import com.dmx.shared.kernel.Utils;
import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class DomainEventJsonDeserializer {

    protected abstract DomainEventsInformation getDomainEventsInformation();

    public DomainEvent deserialize(String body) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        HashMap<String, Serializable> eventData        = Utils.jsonDecode(body);
        HashMap<String, Serializable> data             = (HashMap<String, Serializable>) eventData.get("data");
        HashMap<String, Serializable> attributes       = (HashMap<String, Serializable>) data.get("attributes");
        Class<? extends DomainEvent>  domainEventClass = getDomainEventsInformation().forName((String) data.get("type"));

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

        Method fromPrimitivesMethod = domainEventClass.getMethod(
            "fromPrimitives",
            String.class,
            HashMap.class,
            String.class,
            String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
            nullInstance,
            (String) attributes.get("id"),
            attributes,
            (String) data.get("id"),
            (String) data.get("occurred_on")
        );

        return (DomainEvent) domainEvent;
    }
}
