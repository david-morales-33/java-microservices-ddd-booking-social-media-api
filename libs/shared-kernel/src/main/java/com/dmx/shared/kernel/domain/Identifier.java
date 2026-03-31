package com.dmx.shared.kernel.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    final protected String value;

    public Identifier(String value) {
        ensureValidUuid(value);
        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    public static String generate(){
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
