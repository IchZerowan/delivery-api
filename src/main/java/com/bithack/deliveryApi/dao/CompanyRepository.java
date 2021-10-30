package com.bithack.deliveryApi.dao;

import com.bithack.deliveryApi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
