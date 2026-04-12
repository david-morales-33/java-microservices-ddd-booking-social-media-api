package com.dmx.social_graph.stats.domain;

import java.util.Optional;

public interface StatsRepository {
    void save(Stats stats);

    Optional<Stats> find(UserId id);
}
