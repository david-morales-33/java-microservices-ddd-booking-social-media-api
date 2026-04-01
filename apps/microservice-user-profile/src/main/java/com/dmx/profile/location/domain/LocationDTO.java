package com.dmx.profile.location.domain;

import java.io.Serializable;

public record LocationDTO(String id, String country, String city, String address) implements Serializable {
}
