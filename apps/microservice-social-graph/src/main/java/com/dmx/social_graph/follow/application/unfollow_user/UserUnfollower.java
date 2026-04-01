package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserUnfollower {
    private final FollowRepository repository;

    public UserUnfollower(FollowRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId followerId) {
        Optional<Follow> response = repository.findByUsers(userId, followerId);

        if (response.isEmpty()) throw new FollowDoesNotExistException();

        Follow follow = response.get();

        repository.delete(follow);
    }
}
