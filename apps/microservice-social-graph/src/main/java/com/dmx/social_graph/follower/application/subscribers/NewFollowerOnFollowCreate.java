package com.dmx.social_graph.follower.application.subscribers;

import com.dmx.bus.event.DomainEventSubscriber;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follower.domain.FollowerDTO;
import com.dmx.social_graph.follower.domain.FollowerRepository;
import com.dmx.social_graph.shared.domain.events.UserFollowedDomainEvent;

@Service
public class NewFollowerOnFollowCreate implements DomainEventSubscriber<UserFollowedDomainEvent> {

    private final FollowerRepository repository;

    public NewFollowerOnFollowCreate(FollowerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void on(UserFollowedDomainEvent event) {

        FollowerDTO follower = new FollowerDTO(
                event.getFollowedId(),
                event.getFollowerId(),
                "nn",
                event.occurredOn(),
                "none"
        );
        System.out.println(follower);
        repository.save(follower);
    }

    @Override
    public Class<UserFollowedDomainEvent> subscribedTo() {
        return UserFollowedDomainEvent.class;
    }
}
