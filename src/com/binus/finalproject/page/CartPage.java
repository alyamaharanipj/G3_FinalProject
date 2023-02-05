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
        if (cart.getCartItems().size() == 0){
            System.out.println("|\t\t\t\t\t\t\t\t\tBelum ada barang di keranjang" + "\t\t\t\t\t\t\t\t\t\t|");
            displayBorder("-");
        } else {

            System.out.println("|\tNO" + "\t|\t\t\t" + "NAMA BARANG" + "\t\t\t\t|\t\t" + "HARGA" + "\t\t|\t" + "KUANTITAS" + "\t|\t\t" + "SUBTOTAL" + "\t\t|");
            displayBorder("-");
            int i = 0;
            for (CartItem cartItem : cart.getCartItems()) {
                i++;
                System.out.println(
                        "|" + "\t" + i + "\t|\t\t" + cartItem.getProduct().getName()
                                + calculateSpaceDisplay(cartItem.getProduct().getName(), 29) + "|" + "\tRp " + formatCurrency(cartItem.getProduct().getPrice() + "")
                                + calculateSpaceDisplay(formatCurrency(cartItem.getProduct().getPrice() + ""), 14) + "|" + "\t" + cartItem.getQty()
                                + calculateSpaceDisplay(cartItem.getQty() + "", 14) + "|\tRp " + formatCurrency(cartItem.getQty() * +cartItem.getProduct().getPrice() + "")
                                + calculateSpaceDisplay(formatCurrency(cartItem.getQty() * +cartItem.getProduct().getPrice() + ""), 17) + "|");
                displayBorder("-");
            }
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


   /* private void displayBorder() {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print("* ");
        System.out.println("");
    } */

    public void displayContinuousMenuProductDetail() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\tMENU KERANJANG\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        List<String> menus = Arrays.asList(
                "Pesan Sekarang",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            if (cart.getCartItems().size() == 0) i++;
            System.out.println("|\t" + (i + 1) + "\t|\t" + menus.get(i) + displaySideBorder(menus.get(i)) + "|");
            displayBorder("-");
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu di keranjang : ");
        int selectedMenu = input.nextInt();
        switch (selectedMenu) {
            case 1 : {
                CustomerPage customerPage = new CustomerPage();
                customerPage.display(cart);
            }
        }
    }

}
