package com.bithack.deliveryApi.controller;

import com.bithack.deliveryApi.dao.CompanyRepository;
import com.bithack.deliveryApi.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @GetMapping("")
    List<Company> getAll(){
        return repository.findAll();
    }


}
