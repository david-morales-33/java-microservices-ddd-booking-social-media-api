package com.dmx.shared.kernel.domain;

import java.util.Objects;

public abstract class BooleanValueObject {

    private Boolean value;

    public BooleanValueObject(Boolean value) {
        this.value = value;
    }

    public  Boolean value(){ return this.value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BooleanValueObject that = (BooleanValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
