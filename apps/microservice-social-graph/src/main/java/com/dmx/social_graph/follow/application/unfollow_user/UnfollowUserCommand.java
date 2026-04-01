package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.bus.command.Command;

public class UnfollowUserCommand implements Command {

    private final String userId;
    private final String followerId;

    public UnfollowUserCommand(String userId, String followerId) {
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
