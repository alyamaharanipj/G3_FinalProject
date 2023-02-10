package com.binus.finalproject.page;
import com.binus.finalproject.service.BillingService;
import com.binus.finalproject.service.CustomerService;

import java.util.Scanner;

public class CustomerPage {

    private static final String PAGE_TITLE = "FORM PENDAFTARAN PEMESANAN";

    public static void display () {
        displayTitle();
        saveCustomerData();
        nextDisplay();
    }

    private static void displayTitle() {
        String title = PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static void saveCustomerData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama anda\t\t:\t");
        String username = input.nextLine();
        System.out.print("Masukkan alamat anda\t:\t");
        String address = input.nextLine();
        CustomerService.setData(username, address);
    }

    private static void nextDisplay () {
        Scanner input = new Scanner(System.in);
        System.out.print("\nSemua data yang dimasukkan sudah sesuai? (y/n):  ");
        String selectedMenu = input.next();
        switch (selectedMenu) {
            case "y" : {
                BillingService.setData();
                BillingPage.display();
            } break;
            case "n" : {
                saveCustomerData();
                nextDisplay();
            }
        }
    }
}
