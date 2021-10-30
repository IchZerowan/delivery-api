package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.*;
import com.bithack.deliveryApi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private DishRepository dishRepository;

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

        Long companyId = 0L;
        Map<Dish, Integer> dishesList = new HashMap<>(dishes.size());
        List<OrderDish> orderDishes = new ArrayList<>(dishes.size());

        for(OrderDishDto dish: orderDto.getDishes()){
            Dish dishModel = dishRepository.findById(dish.getDishId())
                    .orElseThrow(() -> new ObjectNotFoundException(Dish.class, dish.getDishId()));

            // Check if dishes are unique
            if(!dishesList.containsKey(dishModel)){
                dishesList.put(dishModel, dish.getCount());
            } else {
                throw new DuplicateDishException(dishModel.getId());
            }

            // Check if single companies' dishes are selected
            Long dishCompanyId = dishModel.getCategory().getCompany().getId();
            if(companyId.equals(0L) || dishCompanyId.equals(companyId)){
                companyId = dishCompanyId;
            } else {
                throw new DifferentCompaniesException(companyId, dishCompanyId);
            }
        }

        OrderM order = new OrderM();
        order.setPhoneNumber(orderDto.getPhoneNumber());
        order.setClientName(orderDto.getClientName());
        order.setDishes(new ArrayList<>(dishes.size()));

        double total = 0;

        for(Map.Entry<Dish, Integer> dishCount: dishesList.entrySet()){
            Dish dish = dishCount.getKey();
            double price = dishCount.getKey().getPrice();
            int count = dishCount.getValue();

            order.getDishes().add(new OrderDish(order, dish, price, count));
            total += price * count;
        }

        order.setTotal(total);
    }
}
