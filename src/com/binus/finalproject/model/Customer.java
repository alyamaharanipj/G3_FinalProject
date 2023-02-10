package com.binus.finalproject.model;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String address;

    // Product constructor
    public Customer(String name, String address) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setAddress(address);
    }

    public Customer() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
