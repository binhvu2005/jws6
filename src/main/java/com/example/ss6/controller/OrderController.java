package com.example.ss6.controller;

import com.example.ss6.entity.Order;
import com.example.ss6.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/date/{date}")
    public List<Order> getOrdersByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date); // format: yyyy-MM-dd
        return orderService.getOrdersByDate(localDate);
    }
}
