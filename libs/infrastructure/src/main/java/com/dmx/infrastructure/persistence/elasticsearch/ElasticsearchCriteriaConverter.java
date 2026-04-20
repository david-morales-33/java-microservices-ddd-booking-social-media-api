package com.dmx.infrastructure.persistence.elasticsearch;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.json.JsonData;
import com.dmx.shared.kernel.criteria.Criteria;
import com.dmx.shared.kernel.criteria.Filter;
import com.dmx.shared.kernel.criteria.FilterOperator;

import java.util.List;
import java.util.stream.Collectors;

public final class ElasticsearchCriteriaConverter {

    public Query convert(Criteria criteria) {
        List<Query> mustQueries = criteria.filters().filters().stream()
                .filter(f -> f.operator().isPositive())
                .map(this::queryForFilter)
                .collect(Collectors.toList());

        List<Query> mustNotQueries = criteria.filters().filters().stream()
                .filter(f -> !f.operator().isPositive())
                .map(this::queryForFilter)
                .collect(Collectors.toList());

        return Query.of(q -> q
                .bool(b -> b
                        .must(mustQueries)
                        .mustNot(mustNotQueries)
                )
        );
    }

    private boolean isPositiveOperator(FilterOperator operator) {
        return operator.isPositive();
    }

    private Query queryForFilter(Filter filter) {

        return switch (filter.operator()) {
            case EQUAL, NOT_EQUAL -> termQuery(filter);
            case GT -> greaterThanQuery(filter);
            case LT -> lowerThanQuery(filter);
            case CONTAINS, NOT_CONTAINS -> wildcardQuery(filter);
        };
    }

    private Query termQuery(Filter filter) {
        return Query.of(q -> q
                .term(t -> t
                        .field(filter.field().value())
                        .value(filter.value().value().toLowerCase())
                )
        );
    }

    private Query greaterThanQuery(Filter filter) {
        return Query.of(q -> q
                .range(r -> r
                        .field(filter.field().value())
                        .gt(JsonData.of(filter.value().value()))
                )
        );
    }

    private Query lowerThanQuery(Filter filter) {
        return Query.of(q -> q
                .range(r -> r
                        .field(filter.field().value())
                        .lt(JsonData.of(filter.value().value()))
                )
        );
    }

    private Query wildcardQuery(Filter filter) {
        return Query.of(q -> q
                .wildcard(w -> w
                        .field(filter.field().value())
                        .value("*" + filter.value().value().toLowerCase() + "*")
                )
        );
    }
}
