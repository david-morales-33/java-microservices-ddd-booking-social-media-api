package com.dmx.social_graph.block.application.unblock_user;

import com.dmx.bus.command.Command;

public class UnblockUserCommand implements Command {
    private String userId;
    private String blockedUserId;

    public UnblockUserCommand(String userId, String blockedUserId) {
        this.userId = userId;
        this.blockedUserId = blockedUserId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBlockedUserId() {
        return blockedUserId;
    }
}
