package com.dmx.social_graph.stats.application.find;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsRepository;
import com.dmx.social_graph.stats.domain.UserId;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatsFinder {
    private final StatsRepository repository;

    public StatsFinder(StatsRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public Stats execute(UserId userId){
        return repository.find(userId).orElseGet(() ->Stats.initialize(userId));
    }
}
