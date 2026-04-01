package com.dmx.social_graph.follow.domain;


import com.dmx.shared.kernel.DomainException;

public class FollowDoesNotExistException extends DomainException {
    public FollowDoesNotExistException() {
        super("FOLLOW_DOES_NOT_EXIST", "The follow relationship does not exist");
    }
}
