package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.bus.query.QueryHandler;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.UserId;

@Service
public final class FindFollowingByUserQueryHandler implements QueryHandler<FindFollowingByUserQuery, FollowingByUserResponse> {

    private final FollowingByUserFinder finder;

    public FindFollowingByUserQueryHandler(FollowingByUserFinder finder) {
        this.finder = finder;
    }

    @Override
    public FollowingByUserResponse handle(FindFollowingByUserQuery query) {
        UserId userId = new UserId(query.userId());
        return this.finder.execute(userId);
    }
}
