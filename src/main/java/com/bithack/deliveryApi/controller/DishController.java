package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.DishRepository;
import com.bithack.deliveryApi.dao.ObjectNotFoundException;
import com.bithack.deliveryApi.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishRepository repository;

    @GetMapping("")
    List<Dish> getAll(@RequestParam Long category_id){
        return repository.findByCategoryId(category_id);
    }

    @GetMapping("/{id}")
    Dish getOne(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Dish.class, id));
    }
}
