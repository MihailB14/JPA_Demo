package com.example.demoJPA.controller;

import com.example.demoJPA.dto.PostalDetailsUserDTO;
import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {
    @Autowired
    CustomersService customersService;

    @PostMapping(value = "/insertCustomer")
    public void InsertCustomer(){
        Customers c = new Customers();
        c.setUsername("MihailB14");
        c.setFirst_name("Mihail");
        c.setLast_name("Barbulescu");
        c.setPhone("0773844123");
        c.setAddress("Bd. Tineretului");
        c.setCity("Bucuresti");
        c.setPostalCode("123456");
        c.setCountry("Romania");
        customersService.CreateCustomer(c);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<Orders>> getOrdersByCustomerId(@PathVariable Integer customerId) {
        try {
            List<Orders> orders = customersService.getOrdersByCustomerId(customerId);

            // Check if any orders were found
            if (orders.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @GetMapping("/{username}/postal_details")
    public ResponseEntity<PostalDetailsUserDTO> getPostalDetailsByUsername(@PathVariable String username) {
        PostalDetailsUserDTO postalDetails = customersService.getPostalDetailsByUsername(username);

        if (postalDetails != null) {
            return ResponseEntity.ok(postalDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
