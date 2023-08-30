package com.example.demoJPA.repository;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomers(Customers customer);
}
