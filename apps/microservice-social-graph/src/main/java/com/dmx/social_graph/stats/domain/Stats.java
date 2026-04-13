package com.dmx.social_graph.stats.domain;

import java.util.Objects;

public final class Stats {
    private UserId userId;
    private StatsCount followersCount;
    private StatsCount followingCount;
    private StatsCount mutedCount;
    private StatsCount blockedCount;

    public Stats(UserId userId, StatsCount followersCount, StatsCount followingCount, StatsCount mutedCount, StatsCount blockedCount) {
        this.userId = userId;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.mutedCount = mutedCount;
        this.blockedCount = blockedCount;
    }

    private Stats() {
        this.userId = null;
        this.followersCount = null;
        this.followingCount = null;
        this.mutedCount = null;
        this.blockedCount = null;
    }

    public void incrementFollowers() {
        this.followersCount = this.followersCount.increment();
    }

    public void incrementUsersFollowing() {
        this.followingCount = this.followingCount.increment();
    }

    public void incrementMutedUsers() {
        this.mutedCount = this.mutedCount.increment();
    }

    public void incrementBlockedUsers() {
        this.blockedCount = this.blockedCount.increment();
    }

    public void decrementFollowers() {
        this.followersCount = this.followersCount.decrement();
    }

    public void decrementUsersFollowing() {
        this.followingCount = this.followingCount.decrement();
    }

    public void decrementMutedUsers() {
        this.mutedCount = this.mutedCount.decrement();
    }

    public void decrementBlockedUsers() {
        this.blockedCount = this.blockedCount.decrement();
    }

    public static Stats initialize(UserId userId) {
        return new Stats(
                userId,
                StatsCount.initialize(),
                StatsCount.initialize(),
                StatsCount.initialize(),
                StatsCount.initialize()
        );
    }

    public static Stats fromPrimitives(StatsDTO stats) {
        return new Stats(
                new UserId(stats.userId()),
                new StatsCount(stats.followersCount()),
                new StatsCount(stats.followingCount()),
                new StatsCount(stats.mutedCount()),
                new StatsCount(stats.blockedCount())
        );
    }

    public StatsDTO toPrimitives() {
        return new StatsDTO(
                this.userId.value(),
                this.followersCount.value(),
                this.followingCount.value(),
                this.mutedCount.value(),
                this.blockedCount.value()
        );
    }

    public UserId getUserId() {
        return userId;
    }

    public StatsCount getFollowersCount() {
        return followersCount;
    }

    public StatsCount getFollowingCount() {
        return followingCount;
    }

    public StatsCount getMutedCount() {
        return mutedCount;
    }

    public StatsCount getBlockedCount() {
        return blockedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return userId.equals(stats.userId) &&
                followersCount.equals(stats.followersCount) &&
                followingCount.equals(stats.followingCount) &&
                mutedCount.equals(stats.mutedCount) &&
                blockedCount.equals(stats.blockedCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, followersCount, followingCount, mutedCount, blockedCount);
    }
}
