package com.example.ss6.controller;

import com.example.ss6.entity.ProductCart;
import com.example.ss6.entity.User;
import com.example.ss6.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class ProductCartController {

    @Autowired
    private ProductCartService productCartService;

    // Giả định người dùng đã đăng nhập và user được lấy từ request/session (tạm hardcode)
    private User getCurrentUser() {
        // TODO: Replace this stub with actual authenticated user
        User user = new User();
        user.setId(1L); // tạm set ID người dùng
        return user;
    }

    @GetMapping
    public List<ProductCart> getCart() {
        return productCartService.getCartItemsByUser(getCurrentUser());
    }

    @PostMapping
    public ProductCart addToCart(@RequestBody ProductCart productCart) {
        productCart.setUser(getCurrentUser());
        return productCartService.addToCart(productCart);
    }

    @PutMapping("/{id}")
    public ProductCart updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        return productCartService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        productCartService.removeFromCart(id);
        return "Removed from cart";
    }
}
