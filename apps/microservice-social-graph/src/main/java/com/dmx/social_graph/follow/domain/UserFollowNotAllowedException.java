package com.dmx.social_graph.follow.domain;

import com.dmx.shared.kernel.DomainException;

public class UserFollowNotAllowedException extends DomainException {
    public UserFollowNotAllowedException(UserId userId, UserId followerId) {
        super("FOLLOW_NOT_ALLOWED","Follow not allowed between user " + userId.value() + " and follower " + followerId.value());
    }
}
