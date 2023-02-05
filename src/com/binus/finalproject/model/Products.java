package com.binus.finalproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Products {
    private UUID id;
    private List<Product> products;

    // Product constructor
    public Products(List<Product> products) {
        this.setId(UUID.randomUUID());
        this.setProducts(products);
    }

    public Products() {
        this.setId(UUID.randomUUID());
        this.setProducts(new ArrayList<>());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
