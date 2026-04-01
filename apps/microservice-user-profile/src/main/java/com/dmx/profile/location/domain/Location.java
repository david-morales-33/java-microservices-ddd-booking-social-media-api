package com.dmx.profile.location.domain;

import java.util.Objects;

public final class Location {

    private final LocationId id;
    private final LocationCountry country;
    private final LocationCity city;
    private final LocationAddress address;

    public Location(LocationId id, LocationCountry country, LocationCity city, LocationAddress address) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Location() {
        this.id = null;
        this.country = null;
        this.city = null;
        this.address = null;
    }

    public static Location create(LocationId id, LocationCountry country, LocationCity city, LocationAddress address) {
        return new Location(id, country, city, address);
    }

    public static Location fromPrimitives(LocationDTO location) {
        return new Location(
                new LocationId(location.id()),
                new LocationCountry(location.country()),
                new LocationCity(location.country()),
                new LocationAddress(location.address())
        );
    }

    public LocationDTO toPrimitives() {
        return new LocationDTO(
                this.id.value(),
                this.country.value(),
                this.city.value(),
                this.address.value()
        );
    }

    public LocationId getId() {
        return id;
    }

    public LocationCountry getCountry() {
        return country;
    }

    public LocationCity getCity() {
        return city;
    }

    public LocationAddress getAddress() {
        return address;
    }

    public boolean compareByContent(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return country.equals(location.country) &&
                city.equals(location.city) &&
                address.equals(location.address);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id.equals(location.id) &&
                country.equals(location.country) &&
                city.equals(location.city) &&
                address.equals(location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, address);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", country=" + country +
                ", city=" + city +
                ", address=" + address +
                '}';
    }
}
