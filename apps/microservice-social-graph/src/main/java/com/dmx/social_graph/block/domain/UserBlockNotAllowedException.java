package com.dmx.social_graph.block.domain;

import com.dmx.shared.kernel.DomainException;

public class UserBlockNotAllowedException extends DomainException {
    public UserBlockNotAllowedException() {
        super("BLOCK_USER_NOT_ALLOWED", "User block is not allowed");
    }
}
