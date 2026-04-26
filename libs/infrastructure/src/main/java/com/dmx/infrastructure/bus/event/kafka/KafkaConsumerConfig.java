package com.dmx.infrastructure.bus.event.kafka;

import com.dmx.infrastructure.config.ParameterNotExist;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

public abstract class KafkaConsumerConfig {
    abstract protected String bootstrapServers() throws ParameterNotExist;
    abstract protected String groupIdConfig() throws ParameterNotExist;

    protected Map<String, Object> consumerConfigs() throws ParameterNotExist {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers(),
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, groupIdConfig(),
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
        );
    }

    protected ConsumerFactory<String, String> consumerFactory() throws ParameterNotExist {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    protected ConcurrentKafkaListenerContainerFactory<String, String> factory() throws ParameterNotExist {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
