package com.bithack.deliveryApi.model;

public class ExceptionInfo {
    public final int status;
    public final String error;

    public ExceptionInfo(int status, Exception e){
        this.status = status;
        error = e.getLocalizedMessage();
    }
}
