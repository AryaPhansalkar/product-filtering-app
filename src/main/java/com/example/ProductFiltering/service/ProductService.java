package com.example.ProductFiltering.service;

import com.example.ProductFiltering.model.Product;
import com.example.ProductFiltering.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> filterProducts(Double maxPrice, String category) {

        List<Product> products = repo.findAll();

        Predicate<Product> priceFilter =
                p -> maxPrice == null || p.getPrice() <= maxPrice;

        Predicate<Product> categoryFilter =
                p -> category == null || category.isEmpty()
                        || p.getCategory().equalsIgnoreCase(category);

        return products.stream()
                .filter(priceFilter.and(categoryFilter))
                .collect(Collectors.toList());
    }
}