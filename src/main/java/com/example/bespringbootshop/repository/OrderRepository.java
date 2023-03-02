package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
