package com.dmx.profile.user_profile.domain;

import com.dmx.profile.status.domain.Status;

import java.util.Optional;

public interface UserProfileService {
    Optional<Status> findDefaultStatus();
}
