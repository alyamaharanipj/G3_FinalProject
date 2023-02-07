package com.binus.finalproject.repository;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Customer;

import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerRepository {
    public static Customer customer = new Customer();

    public static void setData(Customer newCustomer) {
        customer = newCustomer;
    }

    public static Customer getCustomer() {
        return customer;
    }
}