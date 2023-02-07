package com.binus.finalproject.service;

import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Customer;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.repository.CartRepository;
import com.binus.finalproject.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class CustomerService {
    public static List<CartItem> find() {
        return CartRepository.getCartItems();
    }

    public static void setData(String name, String address) {
        Customer customer = new Customer(name, address);
        CustomerRepository.setData(customer);
    }
}
