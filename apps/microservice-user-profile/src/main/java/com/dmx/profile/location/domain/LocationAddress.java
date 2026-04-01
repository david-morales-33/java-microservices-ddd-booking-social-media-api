package com.dmx.profile.location.domain;

import com.dmx.shared.kernel.StringValueObject;

public final class LocationAddress extends StringValueObject {
    public LocationAddress(String value) {
        super(value);
    }

    private LocationAddress() {
        super(null);
    }
}
