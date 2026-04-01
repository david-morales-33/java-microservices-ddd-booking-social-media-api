package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowingByUserFinder {
    private final FollowRepository repository;

    public FollowingByUserFinder(FollowRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public FollowingByUserResponse execute(UserId userId) {
        List<Follow> following = this.repository.findFollowingOf(userId);
        return new FollowingByUserResponse(following);
    }
}
