package com.dmx.social_graph.shared.infrastructure.bus.event.kafka;

import com.dmx.infrastructure.bus.event.kafka.KafkaConsumerConfig;
import com.dmx.infrastructure.config.ParameterNotExist;
import com.dmx.social_graph.shared.infrastructure.config.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class SocialGraphKafkaConsumerConfiguration extends KafkaConsumerConfig {
    private final Parameter config;

    public SocialGraphKafkaConsumerConfiguration(Parameter config) {
        this.config = config;
    }

    @Override
    protected String bootstrapServers() throws ParameterNotExist {
        return String.format(
                "%s:%d",
                config.get("SOCIAL_GRAPH_KAFKA_BOOTSTRAP_SERVER"),
                config.getInt("SOCIAL_GRAPH_KAFKA_PORT")
        );
    }

    @Override
    protected String groupIdConfig() throws ParameterNotExist {
        return config.get("SOCIAL_GRAPH_KAFKA_GROUP_ID");
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() throws ParameterNotExist {
        return factory();
    }
}
