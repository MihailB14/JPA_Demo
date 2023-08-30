package com.example.demoJPA.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Date order_date;

    Date shipped_date;

    String status;

    String comments;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @OneToMany(mappedBy = "ord")
    private List<OrderDetails> orderDetails;


}
