package com.dmx.infrastructure.persistence.elasticsearch;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.dmx.shared.kernel.criteria.Criteria;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ElasticsearchRepository<T> {
    private final ElasticsearchClientAdapter client;
    private final ElasticsearchCriteriaConverter criteriaConverter;

    public ElasticsearchRepository(ElasticsearchClientAdapter client) {
        this.client = client;
        this.criteriaConverter = new ElasticsearchCriteriaConverter();
    }

    abstract protected String moduleName();

    protected List<T> searchAll(Function<Map<String, Object>, T> mapper) {
        try {
            SearchResponse<Map<String, Object>> response = client.client().search(
                    s -> s.index(client.indexFor(moduleName())),
                    (Class<Map<String, Object>>) (Class<?>) Map.class
            );

            return response.hits().hits().stream()
                    .map(hit -> mapper.apply(hit.source()))
                    .collect(Collectors.toList());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<T> searchByCriteria(Criteria criteria, Function<Map<String, Object>, T> unserializer) {
        return Collections.emptyList();
    }

    protected void persist(String id, HashMap<String, Serializable> plainBody) {
        try {
            client.persist(moduleName(), id, plainBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
