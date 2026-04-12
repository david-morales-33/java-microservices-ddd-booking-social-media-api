package com.dmx.social_graph.stats.domain;

import java.io.Serializable;

public record StatsDTO(
        String userId,
        int followersCount,
        int followingCount,
        int mutedCount,
        int blockedCount
) implements Serializable {
}
