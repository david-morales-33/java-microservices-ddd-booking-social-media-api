package com.dmx.app_notification.shared.infrastructure.bus.event.kafka;

import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationDomainEventDeserializer;
import com.dmx.app_notification.shared.infrastructure.bus.event.AppNotificationSubscribersHandler;
import com.dmx.shared.kernel.events.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.reflect.InvocationTargetException;

@Configuration
public class KafkaConsumerListener {
    private final AppNotificationDomainEventDeserializer deserializer;
    private final AppNotificationSubscribersHandler handler;

    public KafkaConsumerListener(AppNotificationDomainEventDeserializer deserializer, AppNotificationSubscribersHandler handler) {
        this.deserializer = deserializer;
        this.handler = handler;
    }

    @KafkaListener(topics = "cdc.social_graph.public.tbl_outbox_event", groupId = "notification-group")
    public void listen(String message) throws JsonProcessingException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DomainEvent event = deserializer.deserialize(message);
        handler.handle(event);
    }
}