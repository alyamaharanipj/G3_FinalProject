package com.binus.finalproject.page;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Customer;
import com.binus.finalproject.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CartPage implements BasePage {
    Cart cart = new Cart();
    @Override
    public void display() {

    }

    public void displayDetailCart(Cart cart) {
        this.cart = cart;
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\tDETAIL KERANJANG" + "\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        displayBorder("-");
        System.out.println("|\tNO" + "\t|\t\t" + "NAMA BARANG" + "\t\t|\t\t" + "HARGA" + "\t\t|\t\t" + "KUANTITAS" + "\t\t\t|\t\t" + "SUBTOTAL"+ "\t\t|");

        displayBorder("-");
        int i = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            i++;
            System.out.println(
                    "|" + "\t" + i + "\t|\t\t" + cartItem.getProduct().getName()
                    + calculateSpaceDisplay(cartItem.getProduct().getName(), 33) + "|" + "\tRp " + formatCurrency(cartItem.getProduct().getPrice() + "")
                    + calculateSpaceDisplay(cartItem.getProduct().getPrice() + "", 17) + "|" + "\t" + cartItem.getProduct().getQty()
                    + calculateSpaceDisplay(cartItem.getQty() + "", 10)
                    + calculateSpaceDisplay(cartItem.getQty() *  + cartItem.getProduct().getPrice() + "", 17));
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
        displayContinuousMenuProductDetail();
        getInputMenuUser();
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


   /* private void displayBorder() {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print("* ");
        System.out.println("");
    } */

    public void displayContinuousMenuProductDetail() {
        System.out.println("\nMENU KERANJANG ");
        List<String> menus = Arrays.asList(
                "Bayar Sekarang",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i));
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPilih salah satu menu detail produk : ");
        int selectedMenu = input.nextInt();
        switch (selectedMenu) {
            case 1 : {
                CustomerPage customerPage = new CustomerPage();
                customerPage.display(cart);
            }
        }
    }

}
