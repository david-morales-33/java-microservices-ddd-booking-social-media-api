package com.dmx.social_graph.stats.application;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsRepository;
import com.dmx.social_graph.stats.domain.UserId;

@Service
public class StatsFinder {
    private final StatsRepository repository;

    public StatsFinder(StatsRepository repository) {
        this.repository = repository;
    }

    public Stats find(UserId userId) {
        return repository.find(userId).orElseGet(() -> Stats.initialize(userId));
    }
}
