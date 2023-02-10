package com.binus.finalproject.service;

import com.binus.finalproject.model.*;
import com.binus.finalproject.repository.BillingRepository;
import com.binus.finalproject.repository.CartRepository;
import com.binus.finalproject.repository.CustomerRepository;

import java.util.*;

public class BillingService {
    public static double getTotalPayment(Cart cart) {
        double price = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            price += cartItem.getQty() * cartItem.getProduct().getPrice();
        }
        return price;
    }

    public static void setData() {
        Cart cart = CartRepository.getCart();
        Customer customer = CustomerRepository.getCustomer();
        BillingRepository.setData(cart, customer, getTotalPayment(cart));
    }

    public static Billing find() {
        return BillingRepository.getBill();
    }

    public static UUID generateVirtualAccount() {
        UUID VA = UUID.randomUUID();
        BillingRepository.setVirtualAccount(VA);
        return BillingRepository.getVirtualAccount();
    }
}
