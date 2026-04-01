package com.dmx.social_graph.block.domain;


import com.dmx.shared.kernel.DomainException;

public class UserBlockThemselvesExcecption extends DomainException {
    public UserBlockThemselvesExcecption(UserId userId) {
        super("USER_BLOCK_THEMSELVES", String.format("User <%s> cannot block themselves", userId.value()));
    }
}
