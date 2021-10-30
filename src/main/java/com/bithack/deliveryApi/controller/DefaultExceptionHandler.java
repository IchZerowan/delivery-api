package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.ObjectNotFoundException;
import com.bithack.deliveryApi.model.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseBody
    ExceptionInfo handleNotFound(HttpServletRequest req, Exception ex) {
        return new ExceptionInfo(404, ex);
    }
}
