package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.bus.command.Command;

public final class FollowUserCommand implements Command {

    private final String userId;
    private final String followerId;

    public FollowUserCommand(String userId, String followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFollowerId() {
        return followerId;
    }
}
