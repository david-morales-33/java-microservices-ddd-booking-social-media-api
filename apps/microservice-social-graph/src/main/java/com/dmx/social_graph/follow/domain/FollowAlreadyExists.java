package com.dmx.social_graph.follow.domain;


import com.dmx.shared.kernel.DomainException;

public class FollowAlreadyExists extends DomainException {
    public FollowAlreadyExists(UserId userId, UserId followerId) {
        super("FOLLOW_ALREADY_EXISTS","Follow already exists between user " + userId.value() + " and follower " + followerId.value());
    }
}
