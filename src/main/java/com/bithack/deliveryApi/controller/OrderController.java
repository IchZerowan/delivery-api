package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.ObjectNotFoundException;
import com.bithack.deliveryApi.dao.OrderRepository;
import com.bithack.deliveryApi.model.OrderM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping("/{id}")
    OrderM getOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(OrderM.class, id));
    }
}
