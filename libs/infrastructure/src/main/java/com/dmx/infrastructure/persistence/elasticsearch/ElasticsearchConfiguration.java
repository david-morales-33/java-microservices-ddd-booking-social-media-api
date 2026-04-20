package com.dmx.infrastructure.persistence.elasticsearch;

import com.dmx.infrastructure.config.ParameterNotExist;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import co.elastic.clients.elasticsearch.ElasticsearchClient;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public abstract class ElasticsearchConfiguration {
    private final ResourcePatternResolver resourceResolver;

    public ElasticsearchConfiguration(ResourcePatternResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    protected void generateIndexIfNotExists(ElasticsearchClient client) throws IOException {
        Resource[] jsonsIndexes = resourceResolver.getResources(
                String.format("classpath:database/elasticsearch/%s/*.json", getModule())
        );

        for (Resource jsonIndex : jsonsIndexes) {
            String indexName = Objects.requireNonNull(jsonIndex.getFilename()).replace(".json", "");

            if (!indexExists(indexName, client)) {
                String indexBody = new Scanner(
                        jsonIndex.getInputStream(),
                        "UTF-8"
                ).useDelimiter("\\A").next();

                client.indices().create(c -> c
                        .index(indexName)
                        .withJson(new java.io.StringReader(indexBody))
                );
            }
        }
    }

    private boolean indexExists(String indexName, ElasticsearchClient client) throws IOException {
        return client.indices().exists(e -> e.index(indexName)).value();
    }

    public abstract ElasticsearchClient elasticsearchClient() throws ParameterNotExist, Exception;

    public abstract String getModule();
}
