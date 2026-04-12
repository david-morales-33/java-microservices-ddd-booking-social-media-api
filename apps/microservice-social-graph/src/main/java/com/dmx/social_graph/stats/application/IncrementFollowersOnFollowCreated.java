package com.dmx.social_graph.stats.application;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.shared.domain.events.UserFollowedDomainEvent;
import com.dmx.social_graph.stats.domain.Stats;
import com.dmx.social_graph.stats.domain.StatsRepository;
import com.dmx.social_graph.stats.domain.UserId;

@Service
public class IncrementFollowersOnFollowCreated implements DomainEventSubscriber<UserFollowedDomainEvent> {

    private final StatsRepository repository;

    public IncrementFollowersOnFollowCreated(StatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void on(UserFollowedDomainEvent event) {
        UserId followedId = new UserId(event.getFollowedId());
        UserId followerId = new UserId(event.getFollowerId());

        Stats followedStats = repository.find(followedId).orElseGet(() -> Stats.initialize(followedId));
        Stats followerStats = repository.find(followerId).orElseGet(() -> Stats.initialize(followerId));

        followedStats.incrementFollowers();
        followerStats.incrementUsersFollowing();

        repository.save(followedStats);
        repository.save(followerStats);
    }

    @Override
    public Class<UserFollowedDomainEvent> subscribedTo() {
        return UserFollowedDomainEvent.class;
    }
}
