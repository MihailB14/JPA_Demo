package com.example.demoJPA.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payments {
    @Id
    @GeneratedValue
    Integer id;
    Date payment_date;

    Double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers payment_customer;
}
