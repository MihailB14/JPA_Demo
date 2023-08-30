package com.example.demoJPA.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customer_id;

    String username;

    String last_name;

    String first_name;

    String phone;

    String address;

    String city;

    String postalCode;

    String country;

    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;

    @OneToMany(mappedBy = "payment_customer")
    private List<Payments> payments;
}

