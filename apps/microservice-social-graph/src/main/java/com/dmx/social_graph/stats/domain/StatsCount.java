package com.dmx.social_graph.stats.domain;

import com.dmx.shared.kernel.IntValueObject;

public class StatsCount extends IntValueObject {
    public StatsCount(Integer value) {
        super(value);
    }

    private StatsCount() {
        super(0);
    }

    public StatsCount increment() {
        return new StatsCount(this.value() + 1);
    }

    public StatsCount decrement() {
        if (this.value() == 0) return this;
        return new StatsCount(this.value() - 1);
    }

    public static StatsCount initialize() {
        return new StatsCount(0);
    }
}
