package com.dmx.infrastructure.persistence.elasticsearch;

import com.dmx.infrastructure.config.Parameter;
import com.dmx.infrastructure.config.ParameterNotExist;
import com.dmx.shared.kernel.Utils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public abstract class ElasticsearchConfiguration {
    private final Parameter               config;
    private final ResourcePatternResolver resourceResolver;

    public ElasticsearchConfiguration(Parameter config, ResourcePatternResolver resourceResolver) {
        this.config           = config;
        this.resourceResolver = resourceResolver;
    }

    protected ElasticsearchClient elasticsearchClient() throws ParameterNotExist, Exception {
		ElasticsearchClient client = new ElasticsearchClient(
			new RestHighLevelClient(
				RestClient.builder(
					new HttpHost(
						config.get("ELASTICSEARCH_HOST"),
						config.getInt("ELASTICSEARCH_PORT"),
						"http"
					)
				)
			),
			RestClient.builder(
				new HttpHost(
					config.get("ELASTICSEARCH_HOST"),
					config.getInt("ELASTICSEARCH_PORT"),
					"http"
				)).build(),
			config.get("ELASTICSEARCH_INDEX_PREFIX")
		);

		Utils.retry(10, 10000, () -> {
            try {
                generateIndexIfNotExists(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return client;
    }

    private void generateIndexIfNotExists(ElasticsearchClient client) throws IOException {
        Resource[] jsonsIndexes = resourceResolver.getResources(
            String.format("classpath:%s/*.json", getModule())
        );

        for (Resource jsonIndex : jsonsIndexes) {
            String indexName = Objects.requireNonNull(jsonIndex.getFilename()).replace(".json", "");

            if (!indexExists(indexName, client)) {
                String indexBody = new Scanner(
                    jsonIndex.getInputStream(),
                    "UTF-8"
                ).useDelimiter("\\A").next();

                Request request = new Request("PUT", indexName);
                request.setJsonEntity(indexBody);

                client.lowLevelClient().performRequest(request);
            }
        }
    }

    private boolean indexExists(String indexName, ElasticsearchClient client) throws IOException {
        return client.highLevelClient().indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
    }

    public abstract String getModule();
}
