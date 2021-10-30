package com.bithack.deliveryApi.dao;

import com.bithack.deliveryApi.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByCategoryId(Long categoryId);
}
