package com.dmx.app_notification.notification.domain;

import com.dmx.shared.kernel.StringValueObject;

public final class ReferenceId extends StringValueObject {
    public ReferenceId(String value) {
        super(value);
    }

    private ReferenceId() {
        super(null);
    }

    public static ReferenceId of(String value) {
        return new ReferenceId(value);
    }
}

