package com.bithack.deliveryApi.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderDishId implements Serializable {
    private Long order;
    private Long dish;

    public OrderDishId() { }

    public OrderDishId(Long order, Long dish) {
        this.order = order;
        this.dish = dish;
    }

    public Long getDish() {
        return dish;
    }

    public void setDish(Long dish) {
        this.dish = dish;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDishId that = (OrderDishId) o;
        return Objects.equals(dish, that.dish) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish, order);
    }
}
