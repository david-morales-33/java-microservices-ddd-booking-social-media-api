package com.dmx.social_graph.shared.infrastructure.persistence.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchClientAdapter;
import com.dmx.shared.kernel.Service;

@Service
public class SocialGraphElasticsearchClientAdapter extends ElasticsearchClientAdapter {
    public SocialGraphElasticsearchClientAdapter(ElasticsearchClient client) {
        super(client, "social_graph");
    }
}
