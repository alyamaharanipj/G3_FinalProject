package com.binus.finalproject.model;

import java.util.List;
import java.util.UUID;

public class CartItem {
    private UUID id;
    private Product product;
    private int qty;

    // Product constructor
    public CartItem(Product product, int qty) {
        this.setId(UUID.randomUUID());
        this.setProduct(product);
        this.setQty(qty);
    }

    public CartItem() {
        this.setId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }
}
