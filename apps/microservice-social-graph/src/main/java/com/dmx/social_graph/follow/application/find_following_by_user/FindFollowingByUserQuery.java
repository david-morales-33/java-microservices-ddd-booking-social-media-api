package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.bus.query.Query;

public final class FindFollowingByUserQuery implements Query {
    private final String userId;

    public FindFollowingByUserQuery(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}
