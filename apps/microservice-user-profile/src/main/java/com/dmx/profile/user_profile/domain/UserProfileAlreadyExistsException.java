package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.DomainException;

public class UserProfileAlreadyExistsException extends DomainException {
    public UserProfileAlreadyExistsException(UserProfileId id) {
        super("USER_PROFILE_ALREADY_EXIST", String.format("The user profile <%s> already exist", id.value()));
    }
}
