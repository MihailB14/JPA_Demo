package com.example.demoJPA.controller;

import com.example.demoJPA.model.Products;
import com.example.demoJPA.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping("/products")
    public List<Products> getAllDogs() {
        return productsService.getAllProducts();
    }

    @PostMapping(value = "/insertProduct1")
    public void InsertJuiceProduct(){
        Products p = new Products();
        p.setName("Coca-Cola");
        p.setPrice(7.52);
        p.setDescription("Un suc carbogazos excelent");
        p.setStock(123);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct2")
    public void InsertJuiceProduct1(){
        Products p = new Products();
        p.setName("Fanta");
        p.setPrice(6.52);
        p.setDescription("Un suc carbogazos excelent de portocale");
        p.setStock(55);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct3")
    public void InsertJuiceProduct3(){
        Products p = new Products();
        p.setName("Lipton");
        p.setPrice(7.50);
        p.setDescription("Un suc necarbogazos excelent cu gust de ceai");
        p.setStock(123);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct4")
    public void InsertJuiceProduct5(){
        Products p = new Products();
        p.setName("Fuzetea");
        p.setPrice(8.52);
        p.setDescription("Un suc necarbogazos excelent care seamana cu Lipton");
        p.setStock(123);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct5")
    public void InsertBreadProduct(){
        Products p = new Products();
        p.setName("GrauIntreg");
        p.setPrice(10.52);
        p.setDescription("O paine foarte interesanta si gustoasa");
        p.setStock(600);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct6")
    public void InsertBreadProduct2(){
        Products p = new Products();
        p.setName("7 seminte");
        p.setPrice(12.22);
        p.setDescription("O paiune foarte interesanta cu multe seminte sanatoase");
        p.setStock(1000);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct7")
    public void InsertBreadProduct4(){
        Products p = new Products();
        p.setName("VelPitar");
        p.setPrice(3.52);
        p.setDescription("O paine excelenta de buget");
        p.setStock(22);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct8")
    public void InsertVegetablesProduct(){
        Products p = new Products();
        p.setName("Rosii Cherry");
        p.setPrice(15.07);
        p.setDescription("Merg super la salata in combinatie cu branza si otet");
        p.setStock(1111);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct9")
    public void InsertVegetablesProduct2(){
        Products p = new Products();
        p.setName("Castraveti");
        p.setPrice(22.33);
        p.setDescription("Merg pusi in salata cat si la ochi");
        p.setStock(123);
        productsService.InsertProduct(p);
    }
    @PostMapping(value = "/insertProduct10")
    public void InsertVegetablesProduct3(){
        Products p = new Products();
        p.setName("Ardei Grasi");
        p.setPrice(8.99);
        p.setDescription("Mananca-i si nu vei fi ca ei");
        p.setStock(10000);
        productsService.InsertProduct(p);
    }
}
