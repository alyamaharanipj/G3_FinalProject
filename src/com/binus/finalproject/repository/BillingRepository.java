package com.binus.finalproject.repository;

import com.binus.finalproject.model.Billing;
import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Customer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BillingRepository {

    public static Billing billing = new Billing();

    public static void setData(Cart cart, Customer customer, double totalPayment) {
        billing.setCart(cart);
        billing.setCustomer(customer);
        billing.setTotalPayment(totalPayment);
    }

    public static Billing getBill() {
        return billing;
    }

    public static UUID getVirtualAccount() {
        return getBill().getVirtualAccount();
    }
}
