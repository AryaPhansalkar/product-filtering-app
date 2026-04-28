package com.example.ProductFiltering.controller;

import com.example.ProductFiltering.model.Product;
import com.example.ProductFiltering.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String category) {

        return service.filterProducts(price, category);
    }
}