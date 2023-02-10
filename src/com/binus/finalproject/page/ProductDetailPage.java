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

public class ProductDetailPage {

    private static final String PAGE_TITLE = "detail produk";

    public static void display(Product product) {
        displayTitle();
        displayBody(product);
        DisplayHelper.confirmDisplayMenu(PAGE_TITLE);
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu, product);
    }

    private static void displayTitle() {
        String title = PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title, 60, 56);
    }

    private static void displayBody(Product product) {
        System.out.println("|\t" + "Nama Produk\t\t\t" + "|\t" + product.getName() + DisplayHelper.calculateSpaceDisplay(product.getName(), 78) + "|");
        System.out.println("|\t" + "Kategori Produk\t\t" + "|\t" + product.getCategory() + DisplayHelper.calculateSpaceDisplay(product.getCategory(), 76) + "|");
        System.out.println("|\t" + "Brand\t\t\t\t" + "|\t" + product.getBrand() + DisplayHelper.calculateSpaceDisplay(product.getBrand(), 80) + "|");
        System.out.println("|\t" + "Harga Produk\t\t" + "|\tRp " + DisplayHelper.formatCurrency(product.getPrice() + "") + DisplayHelper.calculateSpaceDisplay(DisplayHelper.formatCurrency(product.getPrice() + ""), 73) + "|");
        System.out.println("|\t" + "Kuantitas Produk\t" + "|\t" + product.getQty() + " Produk Tersedia" + DisplayHelper.calculateSpaceDisplay(product.getQty() + " Produk Tersedia", 78) + "|");
        DisplayHelper.displayBorder("-");
    }

    private static void displayMenu() {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title, 60, 60);
        List<String> menus = Arrays.asList(
                "Masukkan Keranjang",
                "Lihat Keranjang",
                "Kembali",
                "Keluar"
        );
        DisplayHelper.displayMenu(menus);
    }

    public static void nextDisplay(int selectedMenu, Product product) {
        switch (selectedMenu) {
            case 1 : {
                boolean isValidQty = false;
                while(!isValidQty) {
                    System.out.print("Masukkan jumlah produk\t\t\t\t: ");
                    Scanner input = new Scanner(System.in);
                    int qty = input.nextInt();
                    CartItem cartItem = new CartItem(product, qty);
                    isValidQty = CartService.addToCart(cartItem);
                }
                CartPage.display();
                break;
            }
            case 2 : {
                CartPage.display();
                break;
            }
            case 3 :
                HomePage.display(); break;
            case 4 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplay(selectedMenu, product);
            }
        }
    }
}
