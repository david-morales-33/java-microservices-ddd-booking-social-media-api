package com.dmx.infrastructure.persistence.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public abstract class ElasticsearchClientAdapter {
    private final ElasticsearchClient client;
    private final String indexPrefix;

    public ElasticsearchClientAdapter(ElasticsearchClient client, String indexPrefix) {
        this.client = client;
        this.indexPrefix = indexPrefix;
    }

    public ElasticsearchClient client() {
        return client;
    }

    public String indexPrefix() {
        return indexPrefix;
    }

    public void persist(String moduleName, String id, HashMap<String, Serializable> plainBody) throws IOException {
        client.index(i -> i
                .index(indexFor(moduleName))
                .id(id)
                .document(plainBody)
        );
    }

    public String indexFor(String moduleName) {
        return String.format("%s_%s", indexPrefix(), moduleName);
    }

    public void delete(String index) throws IOException {
        client.indices().delete(d -> d.index(index));
    }
}
