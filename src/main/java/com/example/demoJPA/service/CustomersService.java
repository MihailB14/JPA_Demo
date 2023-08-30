package com.example.demoJPA.service;

import com.example.demoJPA.dto.PostalDetailsUserDTO;
import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.repository.CustomersRepository;
import com.example.demoJPA.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    OrdersRepository ordersRepository;

    public void CreateCustomer(Customers c){
        customersRepository.save(c);
    }

    public List<Orders> getOrdersByCustomerId(Integer id){
        Optional<Customers> customersOptional = customersRepository.findById(id);

        if(customersOptional.isPresent()){
            Customers customer = customersOptional.get();
            return ordersRepository.findByCustomers(customer);
        }
        else{
            return Collections.emptyList();
        }
    }

    public PostalDetailsUserDTO getPostalDetailsByUsername(String username) {
        Customers customer = customersRepository.findByUsername(username);

        if (customer != null) {
            PostalDetailsUserDTO dto = new PostalDetailsUserDTO();
            dto.setAddress(customer.getAddress());
            dto.setPhone(customer.getPhone());
            dto.setCity(customer.getCity());
            return dto;
        } else {
            return null;
        }
    }
}
