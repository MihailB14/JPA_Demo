package com.example.demoJPA.controller;

import com.example.demoJPA.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    @PostMapping("/{customerId}/add_products")
    public ResponseEntity<String> addProductsToOrder(@PathVariable Integer customerId) {
        try {
            orderService.createOrderWithProducts(customerId);
            return ResponseEntity.ok("Products added to the order successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding products to the order: " + e.getMessage());
        }
    }
}