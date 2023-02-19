package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
