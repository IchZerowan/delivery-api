package com.bithack.deliveryApi.model;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    @NotBlank(message = "Field phoneNumber is required")
    private String phoneNumber;
    @NotBlank(message = "Field clientName is required")
    private String clientName;
    private List<OrderDishDto> dishes = new ArrayList<>();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<OrderDishDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderDishDto> dishes) {
        this.dishes = dishes;
    }
}
