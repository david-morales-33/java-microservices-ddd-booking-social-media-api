package com.dmx.profile.role.domain;

import java.util.Objects;

public final class Role {
    private final RoleId id;
    private final RoleName name;

    public Role(RoleId id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
        this.id = null;
        this.name = null;
    }

    public static Role create(RoleId id, RoleName name) {
        return new Role(id, name);
    }

    public static Role fromPrimitives(RoleDTO data) {
        return new Role(
                new RoleId(data.id()),
                new RoleName(data.name())
        );
    }

    public RoleDTO toPrimitives() {
        return new RoleDTO(
                this.id.value(),
                this.name.value()
        );
    }

    public RoleId getId() {
        return this.id;
    }

    public RoleName getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) && name.equals(role.name);
    }

    public boolean compareByContent(RoleName name) {
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + this.id +
                ", name=" + this.name +
                '}';
    }
}
