package com.dmx.profile.status.domain;

import java.util.Objects;

public final class Status {
    private final StatusId id;
    private final StatusLabel label;

    public Status(StatusId id, StatusLabel label) {
        this.id = id;
        this.label = label;
    }

    public Status() {
        this.id = null;
        this.label = null;
    }

    public static Status byDefault(StatusId id){
        return new Status(id, new StatusLabel("available"));
    }

    public static Status fromPrimitives(StatusDTO status) {
        return new Status(new StatusId(status.id()), new StatusLabel(status.label()));
    }

    public StatusDTO toPrimitives() {
        return new StatusDTO(this.id.value(), this.label.value());
    }

    public boolean compareByContent(StatusLabel label) {
        return this.label.equals(label);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) && Objects.equals(label, status.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", label=" + label +
                '}';
    }
}
