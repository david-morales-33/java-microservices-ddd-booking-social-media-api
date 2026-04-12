package com.dmx.social_graph.stats.application;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.shared.domain.events.BlockUserDomainEvent;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsRepository;
import com.dmx.social_graph.stats.domain.UserId;

@Service
public class IncrementStatsOnBlockCreate implements DomainEventSubscriber<BlockUserDomainEvent> {

    private final StatsRepository repository;

    public IncrementStatsOnBlockCreate(StatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void on(BlockUserDomainEvent event) {
        UserId userId = new UserId(event.getUserBlockerId());
        Stats stats = repository.find(userId).orElseGet(() -> Stats.initialize(userId));
        stats.incrementBlockedUsers();
        repository.save(stats);
    }

    @Override
    public Class<BlockUserDomainEvent> subscribedTo() {
        return BlockUserDomainEvent.class;
    }
}
