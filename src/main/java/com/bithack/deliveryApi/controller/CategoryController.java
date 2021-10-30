package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.CategoryRepository;
import com.bithack.deliveryApi.dao.ObjectNotFoundException;
import com.bithack.deliveryApi.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping("")
    List<Category> getAll(@RequestParam Long company_id){
        return repository.findByCompanyId(company_id);
    }

    @GetMapping("/{id}")
    Category getOne(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Category.class, id));
    }
}
