package com.binus.finalproject.service;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BillingService {
    public double getTotalPayment(Cart cart) {
        double price = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            price += cartItem.getQty() * cartItem.getProduct().getPrice();
        }
        return price;
    }
}
