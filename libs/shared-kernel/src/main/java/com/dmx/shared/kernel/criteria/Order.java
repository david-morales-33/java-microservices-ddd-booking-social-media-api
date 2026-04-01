package com.dmx.shared.kernel.criteria;

import java.util.Objects;
import java.util.Optional;

public final class Order {
    private final OrderBy orderBy;
    private final OrderType orderType;

    public Order(OrderBy orderBy, OrderType orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    public static Order fromValues(Optional<String> orderBy, Optional<String> orderType) {
        if (orderBy.isEmpty() || orderType.isEmpty()) return none();
        return switch (orderType.get()) {
            case "asc" -> Order.asc(orderBy.get());
            case "desc" -> Order.desc(orderBy.get());
            default -> Order.none();
        };
    }

    public static Order none() {
        return new Order(new OrderBy(""), OrderType.NONE);
    }

    public static Order desc(String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.DESC);
    }

    public static Order asc(String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.ASC);
    }

    public OrderBy orderBy() {
        return orderBy;
    }

    public OrderType orderType() {
        return orderType;
    }

    public boolean hasOrder() {
        return !orderType.isNone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderBy, order.orderBy) && orderType == order.orderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderBy, orderType);
    }

    public String serialize() {
        return String.format("%s.%s", orderBy.value(), orderType.value());
    }
}
