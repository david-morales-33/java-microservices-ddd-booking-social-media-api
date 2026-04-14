package com.dmx.social_graph.stats.application.find;

import com.dmx.bus.query.Response;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsDTO;

public final class StatsResponse implements Response {
    private final StatsDTO stats;

    public StatsResponse(Stats stats) {
        this.stats = stats.toPrimitives();
    }

    public StatsDTO getStats() {
        return stats;
    }
}
