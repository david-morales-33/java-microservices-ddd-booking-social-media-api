package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository {
    void save(UserProfile profile);

    Optional<UserProfile> find(UserProfileId id);

    List<UserProfile>match(Criteria criteria);
}
