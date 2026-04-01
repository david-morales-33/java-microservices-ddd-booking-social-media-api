package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.StringValueObject;

public final class UserProfileName extends StringValueObject {
    public UserProfileName(String value) {
        super(value);
    }

    private UserProfileName() {
        super(null);
    }
}
