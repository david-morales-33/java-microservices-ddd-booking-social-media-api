package com.dmx.profile.photo.domain;

import com.dmx.shared.kernel.StringValueObject;

import java.util.List;

public final class PhotoType extends StringValueObject {
    public PhotoType(String value) {
        super(value);
        List<String> validValues = List.of("COVER", "PROFILE", "AVATAR");
        if (!validValues.contains(value)) {
            throw new RuntimeException(value);
        }
    }

    public PhotoType() {
        super(null);
    }

    public static PhotoType fromType(Type type) {
        return new PhotoType(
                switch (type) {
                    case COVER -> "COVER";
                    case PROFILE -> "PROFILE";
                    case AVATAR -> "AVATAR";
                }
        );
    }

}
