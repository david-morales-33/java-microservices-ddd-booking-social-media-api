package com.dmx.app_notification.shared.infrastructure.bus.event.kafka;

import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationDomainEventDeserializer;
import com.dmx.shared.kernel.events.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.reflect.InvocationTargetException;

@Configuration
public class ListenerTest {
    private final AppNotificationDomainEventDeserializer deserializer = new AppNotificationDomainEventDeserializer();

    @KafkaListener(topics = "cdc.social_graph.public.tbl_outbox_event", groupId = "notification-group")
    public void listen(String message) {
        try {
            DomainEvent event = deserializer.deserialize(message);
            System.out.println(event.toPrimitives());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
