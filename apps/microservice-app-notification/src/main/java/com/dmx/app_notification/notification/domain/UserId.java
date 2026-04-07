package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.Identifier;

public final class UserId extends Identifier {
    public UserId(String value) {
        super(value);
    }

    private UserId() {
    }

    public static UserId of(String value) {
        return new UserId(value);
    }

}
