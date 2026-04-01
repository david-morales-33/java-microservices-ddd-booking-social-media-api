package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.bus.event.EventBus;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFollower {
    private final FollowRepository repository;
    private final EventBus eventBus;

    public UserFollower(FollowRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId followerId) {
        Follow follow = Follow.create(userId, followerId);
        if (this.repository.existsActiveFollow(followerId, userId)) {
            throw new FollowAlreadyExists(userId, followerId);
        }
        this.repository.save(follow);
        eventBus.publish(follow.pullDomainEvents());
    }
}
