package com.binus.finalproject.page;

import com.binus.finalproject.model.Billing;
import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BillingPage implements BasePage {

    Billing billing = new Billing();
    @Override
    public void display() {

    }

    public void displayBilling(Billing billing) {
        this.billing = billing;
        System.out.println("\n");
        displayBorder("*");
        System.out.println("||\t\t\t\t\t\t\t\t\t\t\tPEMBAYARAN " + "\t\t\t\t\t\t\t\t\t\t\t\t||");
        displayBorder("*");
        System.out.println("Nama Customer\t:\t" + billing.getCustomer().getName());
        System.out.println("Alamat Customer\t:\t" + billing.getCustomer().getAddress());
        System.out.println("Total Pembayaran\t:\t" + billing.getTotalPayment());
        Cart cart = billing.getCart();
        System.out.println("\n==========================================================================================================");
        System.out.println("||\tNO" + "\t||\t\t" + "NAMA BARANG" + "\t\t||\t\t" + "HARGA" + "\t\t||\t\t" + "KUANTITAS" + "\t\t\t||\t\t" + "SUBTOTAL"+ "\t\t\t||");
        System.out.println("==========================================================================================================");
        int i = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            i++;
            System.out.println("" +
                    "||"
                    + "\t" + i + "\t||"
                    + calculateSpaceDisplay(cartItem.getProduct().getName())
                    + calculateSpaceDisplay(cartItem.getProduct().getPrice() + "")
                    + calculateSpaceDisplay(cartItem.getQty() + "")
                    + calculateSpaceDisplay(cartItem.getQty() *  + cartItem.getProduct().getPrice() +""));
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
        displayContinuousMenuProductDetail();
        getInputMenuUser();
    }

    private String calculateSpaceDisplay(String item) {
        return "\t" + item + (item.length() <= 3 ? "\t\t\t" : (item.length() > 3 && item.length() <= 7 ? "\t\t" : item.length() >= 12 ? "" : "\t")) + "\t\t||";
    }

    public void displayContinuousMenuProductDetail() {
        System.out.println("\nMENU PEMBAYARAN ");
        List<String> menus = Arrays.asList(
                "Konfirmasi Pembayaran",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i));
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("\nApakah anda yakin untuk membayar? (y/n):  ");
        String selectedMenu = input.next();
        switch (selectedMenu) {
            case "y" : {
                System.out.print("\nSilakan lakukan pembayaran ke nomor Virtual Account berikut: ");
                System.out.print(billing.getVirtualAccount());

                System.out.print("\nMasukkan y jika anda telah membayar? (y/n):  ");
                String confirmBill = input.next();
                switch (confirmBill) {
                    case "y" : {
                        System.out.print("\nSelamat, transaksi berhasil diproses.");
                        System.out.print("\nTunggu kurir datang ke rumah anda.");
                        System.out.print("\nTerima kasih telah berbelanja di SPORT STORE GROUP 3 - DABA ya, " + billing.getCustomer().getName() + "!");
                    }
                }
            }
        }
    }
}
