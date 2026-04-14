package com.dmx.social_graph.stats.application.find;

import com.dmx.bus.query.QueryHandler;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.stats.domain.UserId;

@Service
public final class FindStatsQueryHandler implements QueryHandler<FindStatsQuery, StatsResponse> {
    private final StatsFinder finder;

    public FindStatsQueryHandler(StatsFinder finder) {
        this.finder = finder;
    }

    @Override
    public StatsResponse handle(FindStatsQuery query) {
        UserId userId = new UserId(query.getUserId());
        return new StatsResponse(finder.execute(userId));
    }
}
