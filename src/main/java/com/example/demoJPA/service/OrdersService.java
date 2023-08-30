package com.example.demoJPA.service;

import com.example.demoJPA.model.Customers;
import com.example.demoJPA.model.OrderDetails;
import com.example.demoJPA.model.Orders;
import com.example.demoJPA.model.Products;
import com.example.demoJPA.repository.OrderDetailsRepository;
import com.example.demoJPA.repository.OrdersRepository;
import com.example.demoJPA.repository.ProductsRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    ProductsRepository productsRepository;

    public void createOrderWithProducts(Integer customer_id){
        Orders order = new Orders();
        order.setOrder_date(new Date());
        order.setStatus("In asteptare");
        order.setId(customer_id);

        Integer n = 5, i=1;
        List<OrderDetails> orderDetails = new ArrayList<>();
        while(n>0 && i==5) {
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setProduct_ord(productsRepository.findAll().get(i));
            orderDetail.setQuantity(1);
            orderDetail.setPriceEach(productsRepository.findAll().get(i).getPrice());
            orderDetail.setOrd(order);
            orderDetails.add(orderDetail);
            n--;
            i++;

    }
        orderDetailsRepository.saveAll(orderDetails);
    }



}
