package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.*;
import com.bithack.deliveryApi.model.Dish;
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

        // Check single company is selected
        Long companyId = 0L;

        for(OrderDishDto dish: orderDto.getDishes()){
            Dish dishModel = dishRepository.findById(dish.getDishId())
                    .orElseThrow(() -> new ObjectNotFoundException(Dish.class, dish.getDishId()));

            Long dishCompanyId = dishModel.getCategory().getCompany().getId();
            if(companyId.equals(0L) || dishCompanyId.equals(companyId)){
                companyId = dishCompanyId;
            } else {
                throw new DifferentCompaniesException(companyId, dishCompanyId);
            }
        }
        OrderM order = new OrderM();
    }
}
