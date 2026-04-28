package com.example.ProductFiltering.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String category;
    private double price;

    public Product() {}

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // GETTERS & SETTERS (IMPORTANT for JPA)

    public int getId() {
        return id;
    }

    public void setId(int id) {   // needed by JPA
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {  // needed by JPA
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {  // needed by JPA
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {  // needed by JPA
        this.price = price;
    }
}