package com.dmx.social_graph.shared.infrastructure.bus.event.kafka;

import com.dmx.shared.kernel.events.DomainEvent;
import com.dmx.social_graph.shared.infrastructure.bus.event.DomainEventJsonSerializer;
import org.springframework.kafka.core.KafkaTemplate;

public final class KafkaDomainEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaDomainEventPublisher(
            KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DomainEvent event) {

        String topic = event.eventName();

        String payload = DomainEventJsonSerializer.serialize(event);

        kafkaTemplate.send(topic, payload);
    }
}
