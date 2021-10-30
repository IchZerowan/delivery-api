package com.bithack.deliveryApi.dao;

public class DifferentCompaniesException extends RuntimeException {
    public DifferentCompaniesException(Long id1, Long id2) {
        super("Order should contain dishes from a single company, found dishes from companies "
                + id1 + " and " + id2);
    }
}
