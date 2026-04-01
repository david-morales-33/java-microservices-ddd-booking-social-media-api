package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowByUserFinder {
    private final FollowRepository repository;

    public FollowByUserFinder(FollowRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public FollowerByUserResponse execute(UserId userId) {
        List<Follow> followers = this.repository.findFollowersOf(userId);
        return new FollowerByUserResponse(followers);
    }
}
