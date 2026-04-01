package com.dmx.profile.photo.domain;

import java.util.Objects;

public final class Photo {
    private final PhotoId id;
    private final PhotoUrl url;
    private final PhotoType type;

    public Photo(PhotoId id, PhotoUrl url, PhotoType type) {
        this.id = id;
        this.url = url;
        this.type = type;
    }

    public Photo() {
        this.id = null;
        this.url = null;
        this.type = null;
    }

    public PhotoId getId() {
        return id;
    }

    public PhotoUrl getUrl() {
        return url;
    }

    public PhotoType getType() {
        return type;
    }

    public static Photo fromPrimitives(PhotoDTO photo) {
        return new Photo(new PhotoId(photo.id()), new PhotoUrl(photo.url()), new PhotoType(photo.type()));
    }

    public PhotoDTO toPrimitives() {
        return new PhotoDTO(this.id.value(), this.url.value(), this.type.value());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id.equals(photo.id) && url.equals(photo.url) && type.equals(photo.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, type);
    }
}
