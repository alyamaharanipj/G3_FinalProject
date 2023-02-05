package com.binus.finalproject.page;

import com.binus.finalproject.model.Billing;
import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.Customer;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.BillingService;
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
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\tFORM PENDAFTARAN PEMESANAN\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama anda\t\t:\t");
        String username = input.nextLine();
        System.out.print("Masukkan alamat anda\t:\t");
        String address = input.nextLine();
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
                BillingService billingService = new BillingService();
                Billing billing = new Billing(cart, customer);
                billing.setTotalPayment(billingService.getTotalPayment(cart));
                billingPage.displayBilling(billing);
                System.out.print("Tekan ENTER untuk melihat menu di pembayaran");
                input.nextLine();
                input.nextLine();
                billingPage.displayContinuousMenuProductDetail();
                billingPage.getInputMenuUser();
            }
        }
    }
}
