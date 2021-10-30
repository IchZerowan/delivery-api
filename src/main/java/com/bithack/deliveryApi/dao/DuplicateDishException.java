package com.bithack.deliveryApi.dao;

public class DuplicateDishException extends RuntimeException {
    public DuplicateDishException(Long dishId) {
        super("Duplicate dish id found: " + dishId);
    }
}
