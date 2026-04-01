package com.dmx.profile.photo.domain;

import java.io.Serializable;

public record PhotoDTO(
        String id,
        String url,
        String type
) implements Serializable {
}
