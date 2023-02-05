package com.binus.finalproject.page;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.CartService;
import com.binus.finalproject.service.ProductService;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductDetailPage implements BasePage {
    ProductService productService = new ProductService();
    CartService cartService = new CartService();
    Product product = new Product();
    @Override
    public void display() {

    }

    public void displayDetailProduct(Product product) {
        this.product = product;
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\tDETAIL PRODUK"+ "\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");

        System.out.println("|\t" + "Nama Produk\t\t\t" + "|\t" + product.getName() + calculateSpaceDisplay(product.getName(), 78) + "|");
        System.out.println("|\t" + "Kategori Produk\t\t" + "|\t" + product.getCategory() + calculateSpaceDisplay(product.getCategory(), 80) + "|");
        System.out.println("|\t" + "Harga Produk\t\t" + "|\tRp " + formatCurrency(product.getPrice() + "") + calculateSpaceDisplay(formatCurrency(product.getPrice() + ""), 73) + "|");
        System.out.println("|\t" + "Kuantitas Produk\t" + "|\t" + product.getQty() + " Produk Tersedia" + calculateSpaceDisplay(product.getQty() + " Produk Tersedia", 78) + "|");
        displayBorder("-");
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

    /*private void displayBorder() {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print("* ");
        System.out.println("");
    }*/

    public void displayContinuousMenuProductDetail() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\tMENU DETAIL PRODUK\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        List<String> menus = Arrays.asList(
                "Masukkan Keranjang",
                "Beli Sekarang",
                "Lihat Keranjang",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("|\t" + (i + 1) + "\t|\t" + menus.get(i) + displaySideBorder(menus.get(i)) + "|");
            displayBorder("-");
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu detail produk\t: ");
        int selectedMenu = input.nextInt();

        CartPage cartPage = new CartPage();
        switch (selectedMenu) {
            case 1 : {
                System.out.print("Masukkan jumlah produk\t\t\t\t: ");
                int qty = input.nextInt();
                CartItem cartItem = new CartItem(product, qty);
                cartService.addToCart(cartItem);
                Cart cart = cartService.getCart();
                cartPage.displayDetailCart(cart);
                System.out.print("Tekan ENTER untuk melihat menu di detail produk");
                input.nextLine();
                input.nextLine();
                cartPage.displayContinuousMenuProductDetail();
                cartPage.getInputMenuUser();
                break;
            }
        }
    }

}
