package com.bithack.deliveryApi.dao;

public class EmptyOrderException extends RuntimeException {
    public EmptyOrderException() {
        super("The order is empty");
    }
}
