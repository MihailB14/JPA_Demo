package com.example.demoJPA.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderDetails {

    @Id
    @GeneratedValue
    Integer idd;

    Integer quantity;

    Double priceEach;

    @ManyToOne
    @JoinColumn(name = "id")
    private Orders ord;

    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName="code")
    private Products product_ord;
}
