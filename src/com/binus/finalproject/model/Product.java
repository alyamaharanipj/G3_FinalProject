package com.binus.finalproject.model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String category;
    private float price;
    private int qty;

    // Product constructor
    public Product(String name, String category, float price, int qty) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setCategory(category);
        this.setPrice(price);
        this.setQty(qty);
    }

    public Product() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
