package com.dmx.social_graph.shared.infrastructure.persistence.elasticsearch;

import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchConfiguration;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import com.dmx.infrastructure.config.ParameterNotExist;
import com.dmx.shared.kernel.Utils;
import com.dmx.social_graph.shared.infrastructure.config.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
public class SocialGraphElasticsearchConfiguration extends ElasticsearchConfiguration {
    private final Parameter config;

    public SocialGraphElasticsearchConfiguration(Parameter config, ResourcePatternResolver resourceResolver) {
        super(resourceResolver);
        this.config = config;
    }
    @Override
    @Bean
    public ElasticsearchClient elasticsearchClient() throws ParameterNotExist, Exception {
        RestClient restClient = RestClient.builder(
                new HttpHost(
                        config.get("SOCIAL_GRAPH_ELASTICSEARCH_HOST"),
                        config.getInt("SOCIAL_GRAPH_ELASTICSEARCH_PORT"),
                        "http"
                )
        ).build();

        RestClientTransport transport =
                new RestClientTransport(restClient, new JacksonJsonpMapper());

        ElasticsearchClient client = new ElasticsearchClient(transport);

        Utils.retry(10, 10000, () -> {
            try {
                generateIndexIfNotExists(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return client;
    }
}
