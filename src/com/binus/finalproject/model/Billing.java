package com.binus.finalproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Billing {
    private UUID id;
    private Cart cart;
    private Customer customer;
    private double totalPayment;
    private UUID virtualAccount;

    public Billing(Cart cart, Customer customer) {
        this.setId(UUID.randomUUID());
        this.cart = cart;
        this.customer = customer;
        this.setVirtualAccount(UUID.randomUUID());
    }

    public Billing() {
        this.setId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public UUID getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(UUID virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
