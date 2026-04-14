package com.dmx.social_graph.stats.application.find;

import com.dmx.bus.query.Query;

public final class FindStatsQuery implements Query {
    private final String UserId;

    public FindStatsQuery(String userId) {
        UserId = userId;
    }

    public String getUserId() {
        return UserId;
    }
}
