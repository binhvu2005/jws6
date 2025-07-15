package com.example.ss6.repository;

import com.example.ss6.entity.ProductCart;
import com.example.ss6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByUser(User user);
}
