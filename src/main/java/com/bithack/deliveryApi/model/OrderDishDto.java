package com.bithack.deliveryApi.model;

public class OrderDishDto {
    private int dishId;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDish() {
        return dishId;
    }

    public void setDish(int dish) {
        this.dishId = dish;
    }
}
