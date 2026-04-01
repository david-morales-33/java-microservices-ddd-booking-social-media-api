package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.bus.query.Query;

public final class FindFollowerByUserQuery implements Query {
    private final String userId;

    public FindFollowerByUserQuery(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}

