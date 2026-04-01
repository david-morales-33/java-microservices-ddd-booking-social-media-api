package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.bus.command.CommandHandler;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.follow.domain.UserId;

@Service
public class UnfollowUserCommandHandler implements CommandHandler<UnfollowUserCommand> {
    private final UserUnfollower userUnfollower;

    public UnfollowUserCommandHandler(UserUnfollower userUnfollower) {
        this.userUnfollower = userUnfollower;
    }

    @Override
    public void handle(UnfollowUserCommand command) {
        UserId userId = new UserId(command.getUserId());
        UserId followerId = new UserId(command.getFollowerId());
        userUnfollower.execute(userId, followerId);
    }
}
