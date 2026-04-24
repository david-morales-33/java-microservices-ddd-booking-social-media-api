package com.dmx.profile.shared.domain.events;

import com.dmx.shared.kernel.events.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UserProfileCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String nickname;
    private final String photo;
    private final String description;

    public UserProfileCreatedDomainEvent(String aggregateId, String name, String nickname, String photo, String description) {
        super(aggregateId);
        this.name = name;
        this.nickname = nickname;
        this.photo = photo;
        this.description = description;
    }

    public UserProfileCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String nickname, String photo, String description) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.nickname = nickname;
        this.photo = photo;
        this.description = description;
    }

    public UserProfileCreatedDomainEvent(String name, String nickname, String photo, String description) {
        this.name = name;
        this.nickname = nickname;
        this.photo = photo;
        this.description = description;
    }

    @Override
    public String eventName() {
        return "user.profile.create";
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("name", name);
            put("nickname", nickname);
            put("photo", photo);
            put("description", description);

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UserProfileCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("nickname"),
                (String) body.get("photo"),
                (String) body.get("description")

        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileCreatedDomainEvent that = (UserProfileCreatedDomainEvent) o;
        return aggregateId().equals(that.aggregateId()) &&
                name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                photo.equals(that.photo) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggregateId(), name, nickname, photo, description);
    }
}
