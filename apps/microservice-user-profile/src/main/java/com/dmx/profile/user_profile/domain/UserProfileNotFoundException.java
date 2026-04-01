package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.DomainException;

public class UserProfileNotFoundException extends DomainException {
    public UserProfileNotFoundException(UserProfileId id) {
        super("USER_PROFILE_NOT_EXISTS", String.format("The user profile <%s> doesn't exist", id.value()));
    }
}
