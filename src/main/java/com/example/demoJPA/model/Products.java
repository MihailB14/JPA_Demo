package com.example.demoJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    String code;

    String name;

    String description;

    Integer stock;

    Double price;

    @OneToMany(mappedBy = "product_ord")
    private List<OrderDetails> orderDetails;
}
