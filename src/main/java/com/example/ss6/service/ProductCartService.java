package com.example.ss6.service;

import com.example.ss6.entity.ProductCart;
import com.example.ss6.entity.User;
import com.example.ss6.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;

    public List<ProductCart> getCartItemsByUser(User user) {
        return productCartRepository.findByUser(user);
    }

    public ProductCart addToCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    public ProductCart updateQuantity(Long id, Integer quantity) {
        return productCartRepository.findById(id).map(cart -> {
            cart.setQuantity(quantity);
            return productCartRepository.save(cart);
        }).orElse(null);
    }

    public void removeFromCart(Long id) {
        productCartRepository.deleteById(id);
    }
}
