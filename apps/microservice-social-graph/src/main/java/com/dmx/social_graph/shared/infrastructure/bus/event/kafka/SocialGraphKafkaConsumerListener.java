package com.dmx.social_graph.shared.infrastructure.bus.event.kafka;

import com.dmx.infrastructure.config.ParameterNotExist;
import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.social_graph.shared.infrastructure.bus.event.SocialGraphDomainEventDeserializer;
import com.dmx.social_graph.shared.infrastructure.bus.event.SocialGraphSubscribersHandler;
import com.dmx.social_graph.shared.infrastructure.config.Parameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.reflect.InvocationTargetException;

@Configuration
public class SocialGraphKafkaConsumerListener {
    private final SocialGraphDomainEventDeserializer deserializer;
    private final SocialGraphSubscribersHandler handler;

    public SocialGraphKafkaConsumerListener(
            SocialGraphDomainEventDeserializer deserializer,
            SocialGraphSubscribersHandler handler
    ) throws ParameterNotExist {
        this.deserializer = deserializer;
        this.handler = handler;
    }

    @KafkaListener(
            topics = "cdc.user_profile.public.tbl_outbox_event",
            groupId = "profile-group")
    public void listen(String message) throws JsonProcessingException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException{
        DomainEvent event = deserializer.deserialize(message);
        handler.handle(event);
    }
}
