package com.binus.finalproject.page;

import com.binus.finalproject.model.Billing;
import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.Customer;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerPage implements BasePage {

    Customer customer = new Customer();
    Cart cart = new Cart();
    @Override
    public void display() { }

    public void display (Cart cart) {
        this.cart = cart;
        System.out.println("\n");
        displayBorder("*");
        System.out.println("||\t\t\t\t\t\t\t\t\t\t\tDATA DIRI " + "\t\t\t\t\t\t\t\t\t\t\t\t||");
        displayBorder("*");
        Scanner input = new Scanner(System.in);
        System.out.print("\nMasukkan nama anda\t:\t");
        String username = input.next();
        System.out.print("\nMasukkan alamat anda\t:\t");
        String address = input.next();
        customer.setName(username);
        customer.setAddress(address);
        getInputMenuUser();
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("\nSemua data yang dimasukkan sudah sesuai? (y/n):  ");
        String selectedMenu = input.next();
        switch (selectedMenu) {
            case "y" : {
                BillingPage billingPage = new BillingPage();
                Billing billing = new Billing(cart, customer);
                billingPage.displayBilling(billing);
            }
        }
    }
}
