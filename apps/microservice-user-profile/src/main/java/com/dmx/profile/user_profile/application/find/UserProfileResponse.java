package com.dmx.profile.user_profile.application.find;

import com.dmx.bus.query.Response;
import com.dmx.profile.user_profile.domain.UserProfileDTO;

public final class UserProfileResponse implements Response {
    private final UserProfileDTO response;

    public UserProfileResponse(UserProfileDTO response) {
        this.response = response;
    }

    public UserProfileDTO response() {
        return response;
    }
}
