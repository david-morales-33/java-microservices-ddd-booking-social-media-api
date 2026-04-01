package com.dmx.profile.photo.domain;

import com.dmx.shared.kernel.BooleanValueObject;

public final class PhotoState extends BooleanValueObject {
    public PhotoState(Boolean value) {
        super(value);
    }

    public PhotoState() {
        super(null);
    }

    public static PhotoState setOnExistingPhoto() {
        return new PhotoState(true);
    }

    public static PhotoState setOnNoExistingPhoto() {
        return new PhotoState(false);
    }
}
