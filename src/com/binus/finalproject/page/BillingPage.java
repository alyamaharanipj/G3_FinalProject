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
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\tPEMBAYARAN\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        System.out.println("Nama Customer\t\t:\t" + billing.getCustomer().getName());
        System.out.println("Alamat Customer\t\t:\t" + billing.getCustomer().getAddress());
        System.out.println("Total Pembayaran\t:\tRp " + formatCurrency(billing.getTotalPayment() + ""));
        Cart cart = billing.getCart();
        displayBorder("-");
        System.out.println("|\tNO" + "\t|\t\t\t" + "NAMA BARANG" + "\t\t\t\t|\t\t" + "HARGA" + "\t\t|\t" + "KUANTITAS" + "\t|\t\t" + "SUBTOTAL"+ "\t\t|");
        displayBorder("-");
        int i = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            i++;
            System.out.println(
                    "|" + "\t" + i + "\t|\t\t" + cartItem.getProduct().getName()
                            + calculateSpaceDisplay(cartItem.getProduct().getName(), 29) + "|" + "\tRp " + formatCurrency(cartItem.getProduct().getPrice() + "")
                            + calculateSpaceDisplay(formatCurrency(cartItem.getProduct().getPrice() + ""), 14) + "|" + "\t" + cartItem.getQty()
                            + calculateSpaceDisplay(cartItem.getQty() + "", 14) + "|\tRp " + formatCurrency(cartItem.getQty() *  + cartItem.getProduct().getPrice() + "")
                            + calculateSpaceDisplay(formatCurrency(cartItem.getQty() *  + cartItem.getProduct().getPrice() + ""), 17)  + "|");
            displayBorder("-");
        }
    }

    private String formatCurrency(String original) {
        String afterFormatting = "";
        int iterator = 1;
        for (int i = original.length() - 3; i >= 0; i--) {
            afterFormatting += original.toCharArray()[i];
            if(iterator % 3 == 0 && iterator!= 0 && i != 0)
                afterFormatting += ".";
            iterator++;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(afterFormatting);
        return builder.reverse().toString();
    }

    private String calculateSpaceDisplay(String menu, int base) {
        int countedTab = (int) Math.round((double)(base - menu.length()) / 4.0);
        String tabPrinted = "";
        for(int i = 0; i < countedTab; i++)
            tabPrinted += "\t";
        return tabPrinted;
    }

    public void displayContinuousMenuProductDetail() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\tMENU PEMBAYARAN\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        List<String> menus = Arrays.asList(
                "Konfirmasi Pembayaran",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("|\t" + (i + 1) + "\t|\t" + menus.get(i) + displaySideBorder(menus.get(i)) + "|");
            displayBorder("-");
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu di pembayaran\t:  ");
        int selectedMenu = input.nextInt();
        switch (selectedMenu) {
            case 1 : {
                System.out.print("\nSilakan lakukan pembayaran ke nomor Virtual Account berikut: ");
                System.out.println(billing.getVirtualAccount());

                System.out.print("\nMasukkan y jika anda telah membayar? (y/n):  ");
                String confirmBill = input.next();
                switch (confirmBill) {
                    case "y" : {
                        MenuPage menuPage = new MenuPage();
                        System.out.print("\nSelamat, transaksi berhasil diproses.");
                        System.out.print("\nTunggu kurir datang ke rumah anda.");
                        System.out.print("\nTerima kasih telah berbelanja di SPORT STORE GROUP 3 - DABA ya, " + billing.getCustomer().getName() + "!");

                        System.out.print("Tekan ENTER untuk kembali ke menu utama");
                        input.nextLine();
                        input.nextLine();
                        menuPage.display();
                    }
                }
            }
        }
    }
}
