package com.bithack.deliveryApi.dao;

import com.bithack.deliveryApi.model.OrderM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderM, Long> {
}
