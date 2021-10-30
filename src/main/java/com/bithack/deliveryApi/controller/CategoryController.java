package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.CategoryRepository;
import com.bithack.deliveryApi.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping("")
    List<Category> getAll(@RequestParam Long company_id){
        return repository.findByCompany(company_id);
    }

}
