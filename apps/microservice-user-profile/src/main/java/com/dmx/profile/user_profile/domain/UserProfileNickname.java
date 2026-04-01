package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.StringValueObject;

public final class UserProfileNickname extends StringValueObject {
    public UserProfileNickname(String value) {
        super(value);
    }

    private UserProfileNickname() {
        super(null);
    }
}
