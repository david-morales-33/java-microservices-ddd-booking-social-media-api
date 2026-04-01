package com.dmx.social_graph.follow.domain;

import com.dmx.shared.kernel.Identifier;

public class FollowId extends Identifier {

    public FollowId(String value) {
        super(value);
    }
    private FollowId () {}

    public static FollowId of(String value) {
        return new FollowId(value);
    }
}
