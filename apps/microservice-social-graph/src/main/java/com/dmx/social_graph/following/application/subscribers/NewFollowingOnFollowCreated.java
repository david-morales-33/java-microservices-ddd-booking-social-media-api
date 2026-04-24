package com.dmx.social_graph.following.application.subscribers;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.following.domain.FollowingDTO;
import com.dmx.social_graph.following.domain.FollowingRepository;
import com.dmx.social_graph.shared.domain.events.UserFollowedDomainEvent;

@Service
public class NewFollowingOnFollowCreated implements DomainEventSubscriber<UserFollowedDomainEvent> {
    private final FollowingRepository repository;

    public NewFollowingOnFollowCreated(FollowingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void on(UserFollowedDomainEvent event) {
        FollowingDTO following = new FollowingDTO(
                event.getFollowerId(),
                event.getFollowedId(),
                "nn",
                event.occurredOn(),
                "none"
        );
        repository.save(following);
    }

    @Override
    public Class<UserFollowedDomainEvent> subscribedTo() {
        return UserFollowedDomainEvent.class;
    }
}
