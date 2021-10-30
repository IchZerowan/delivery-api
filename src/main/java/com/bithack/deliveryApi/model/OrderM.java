package com.bithack.deliveryApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderM {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private int orderNumber;
    private int amount;
    private String phoneNumber;
    private String clientName;

    public OrderM(){}

    public OrderM(int orderNumber, int sum, String phoneNumber, String clientName){
        this.orderNumber = orderNumber;
        this.amount = sum;
        this.phoneNumber = phoneNumber;
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
