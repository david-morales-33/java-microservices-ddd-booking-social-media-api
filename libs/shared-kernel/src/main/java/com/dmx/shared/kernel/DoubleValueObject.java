package com.dmx.shared.kernel;

import java.util.Objects;

public class DoubleValueObject {

    private Double value;

    public DoubleValueObject(Double value) {
        this.value = value;
    }

    public Double value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DoubleValueObject that = (DoubleValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
