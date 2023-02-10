package com.binus.finalproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private UUID id;
    private List<CartItem> cartItems;

    public Cart(List<CartItem> cartItems) {
        this.setId(UUID.randomUUID());
        this.setCartItems(cartItems);
    }

    public Cart() {
        this.setId(UUID.randomUUID());
        this.setCartItems(new ArrayList<>());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
