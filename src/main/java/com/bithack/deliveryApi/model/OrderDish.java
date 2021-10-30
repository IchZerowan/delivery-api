package com.bithack.deliveryApi.model;

import javax.persistence.*;

@Entity
@Table(name = "order_dish")
@IdClass(OrderDishId.class)
public class OrderDish {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderM order;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    private double price;
    private int count;

    public OrderDish() { }

    public OrderDish(OrderM order, Dish dish, double price, int count) {
        this.order = order;
        this.dish = dish;
        this.price = price;
        this.count = count;
    }

    public Dish getDish() {
        return dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
