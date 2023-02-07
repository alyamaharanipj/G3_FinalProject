package com.binus.finalproject.page;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.CartService;
import com.binus.finalproject.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayHelper {
    public static void displayBorder(String chara) {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print(chara + " ");
        System.out.println("");
    }

    public static void displayHeader(String title) {
        displayBorder("-");
        System.out.println("|" + displaySideBorder(title, 61) + title + displaySideBorder(title, 61) + "|");
        displayBorder("-");
    }

    public static void displayMenu(List<String> menu) {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("|\t" + (i + 1) + "\t|\t" + menu.get(i) + displaySideBorder(menu.get(i), 93) + "|");
            displayBorder("-");
        }
    }

    public static String displaySideBorder(String menu, int allSize) {
        int countedTab = (int) Math.round((double)(allSize - menu.length()) / 4.0);
        String tabPrinted = "";
        for(int i = 0; i < countedTab; i++)
            tabPrinted += "\t";
        return tabPrinted;
    }

    public static void displayTableProduct(List<Product> products) {
        displayBorder("-");
        System.out.println("|\tNO" + "\t|\t\t\t\t" + "NAMA BARANG" + "\t\t\t\t|\t\t" + "KATEGORI" + "\t\t|\t\t" + "HARGA" + "\t\t|\t" + "STOK"+ "\t|");
        displayBorder("-");
        int i = 0;
        for (Product product : products) {
            i++;
            System.out.println("" +
                    "|"
                    + "\t" + i + "\t|\t\t" + product.getName()
                    + calculateSpaceDisplay(product.getName(), 33) + "|" + "\t\t" + product.getCategory()
                    + calculateSpaceDisplay(product.getCategory(), 17) + "|" + "\tRp " + formatCurrency(product.getPrice() + "")
                    + calculateSpaceDisplay(product.getPrice() + "", 14) + "|" + "\t" + product.getQty()
                    + calculateSpaceDisplay(product.getQty() + "", 10) + "|");
            displayBorder("-");
        }
    }

    public static void displayTableCartItems() {
        displayBorder("-");
        System.out.println("|\tNO" + "\t|\t\t\t\t" + "NAMA BARANG" + "\t\t\t|\t\t" + "HARGA" + "\t\t|\t" + "KUANTITAS" + "\t|\t\t" + "SUBTOTAL"+ "\t\t|");
        displayBorder("-");
        int i = 0;
        for (CartItem cartItem : CartService.find()) {
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

    public static String formatCurrency(String original) {
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

    public static String calculateSpaceDisplay(String menu, int base) {
        int countedTab = (int) Math.round((double)(base - menu.length()) / 4.0);
        String tabPrinted = "";
        for(int i = 0; i < countedTab; i++)
            tabPrinted += "\t";
        return tabPrinted;
    }

    public static void confirmDisplayMenu() {
        System.out.print("Tekan ENTER untuk melihat menu di detail produk");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        input.nextLine();
    }

    public static int getMenuReq(String pageTitle) {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu " + pageTitle + "\t\t\t:\t");
        int selectedMenu = input.nextInt();
        return selectedMenu;
    }
}
