package com.dmx.profile.location.domain;

import com.dmx.shared.kernel.StringValueObject;

public final class LocationCountry extends StringValueObject {
    public LocationCountry(String value) {
        super(value);
    }

    private LocationCountry() {
        super(null);
    }
}
