package com.binus.finalproject.page;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.BillingService;
import com.binus.finalproject.service.CartService;
import com.binus.finalproject.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BillingPage {
    private static final String PAGE_TITLE = "pembayaran";

    public static void display() {
        displayTitle();
        displayDataCustomer();
        displayListCartItem();
        DisplayHelper.confirmDisplayMenu(PAGE_TITLE);
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu);
    }

    private static void displayTitle() {
        String title = PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static void displayDataCustomer() {
        System.out.println("Nama Customer\t\t:\t" + BillingService.find().getCustomer().getName());
        System.out.println("Alamat Customer\t\t:\t" + BillingService.find().getCustomer().getAddress());
        System.out.println("Total Pembayaran\t:\tRp " + DisplayHelper.formatCurrency(BillingService.find().getTotalPayment() + ""));
    }

    private static void displayListCartItem() {
        DisplayHelper.displayTableCartItems();
    }

    private static void displayMenu() {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
        List<String> menus = Arrays.asList(
                "Konfirmasi Pembayaran",
                "Kembali"
        );
        DisplayHelper.displayMenu(menus);
    }

    public static void nextDisplay(int selectedMenu) {
        switch (selectedMenu) {
            case 1 : {
                System.out.print("\nSilakan lakukan pembayaran ke nomor Virtual Account berikut: ");
                System.out.println(BillingService.generateVirtualAccount());

                System.out.print("\nMasukkan y jika anda telah membayar? (y/n):  ");
                Scanner input = new Scanner(System.in);
                String confirmBill = input.next();

                switch (confirmBill) {
                    case "y" : {
                        ProductService.updateQty();
                        CartService.clearCart();
                        System.out.println("\nSelamat, transaksi berhasil.");
                        System.out.println("\nPesanan akan segera diproses");
                        System.out.println("\nTerima kasih telah berbelanja di SPORT STORE GROUP 3 - DABA ya, " + BillingService.find().getCustomer().getName() + "!\n");

                        System.out.println("\nTekan ENTER untuk kembali ke menu utama");
                        input.nextLine();
                        input.nextLine();
                        HomePage.display();
                    }
                    case "n" : {
                        System.out.print("\nSEGERA LAKUKAN PEMBAYARAN!");
                        nextDisplay(1);
                    }
                }
            }
        }
    }
}
