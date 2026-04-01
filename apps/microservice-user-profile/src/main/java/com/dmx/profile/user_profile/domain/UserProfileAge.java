package com.dmx.profile.user_profile.domain;

import com.dmx.shared.kernel.IntValueObject;

public final class UserProfileAge extends IntValueObject {
    public UserProfileAge(Integer value) {
        super(value);
        if (!this.isPositive(value)) throw new AgeNotValidException("Age not valid");

    }

    private UserProfileAge() {
        super(null);
    }

    private boolean isPositive(Integer value) {
        return value > 0;
    }
}
