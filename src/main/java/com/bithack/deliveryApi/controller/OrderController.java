package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.EmptyOrderException;
import com.bithack.deliveryApi.dao.ObjectNotFoundException;
import com.bithack.deliveryApi.dao.OrderRepository;
import com.bithack.deliveryApi.model.OrderDishDto;
import com.bithack.deliveryApi.model.OrderDto;
import com.bithack.deliveryApi.model.OrderM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("")
    void create(@RequestBody OrderDto orderDto){
        List<OrderDishDto> dishes = orderDto.getDishes();
        if(dishes.size() < 1){
            throw new EmptyOrderException();
        }

        for(OrderDishDto dish: orderDto.getDishes()){

        }
        OrderM order = new OrderM();
    }
}
