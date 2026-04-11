package com.dmx.social_graph.follow.domain;

import com.dmx.shared.kernel.AggregateRoot;
import com.dmx.social_graph.shared.domain.events.UserFollowedDomainEvent;

import java.util.Objects;

public class Follow extends AggregateRoot {
    private final FollowId id;
    private final UserId userId;
    private final UserId followerId;
    private final FollowInstant createdAt;

    public Follow(FollowId id, UserId userId, UserId followerId) {
        if (userId.equals(followerId)) {
            throw new UserFollowThemselvesExecption(followerId);
        }
        this.id = id;
        this.followerId = followerId;
        this.userId = userId;
        this.createdAt = FollowInstant.now();
    }

    private Follow() {
        this.id = null;
        this.followerId = null;
        this.userId = null;
        this.createdAt = null;
    }


    public static Follow create(UserId userId, UserId followerId) {
        FollowId followId = new FollowId(FollowId.generate());
        Follow follow = new Follow(
                followId,
                userId,
                followerId
        );
        follow.record(new UserFollowedDomainEvent(followId.value(), followerId.value(), userId.value()));
        return follow;
    }

    public FollowId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public UserId getFollowerId() {
        return followerId;
    }


    public FollowInstant getCreatedAt() {
        return createdAt;
    }

    public FollowDTO toPrimitives() {
        return new FollowDTO(
                this.id.value(),
                this.userId.value(),
                this.followerId.value(),
                this.createdAt.value().toString()
        );
    }

    public static Follow fromPrimitives(FollowDTO dto) {
        return new Follow(
                new FollowId(dto.id()),
                new UserId(dto.userId()),
                new UserId(dto.followerId())
        );

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return userId.equals(follow.userId) &&
                followerId.equals(follow.followerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, followerId);
    }
}
