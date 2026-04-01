package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.bus.query.QueryHandler;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.UserId;

@Service
public final class FindFollowByUserQueryHandler implements QueryHandler<FindFollowerByUserQuery, FollowerByUserResponse> {

    private final FollowByUserFinder finder;

    public FindFollowByUserQueryHandler(FollowByUserFinder finder) {
        this.finder = finder;
    }

    @Override
    public FollowerByUserResponse handle(FindFollowerByUserQuery query) {
        UserId userId = new UserId(query.userId());
        return this.finder.execute(userId);
    }
}
