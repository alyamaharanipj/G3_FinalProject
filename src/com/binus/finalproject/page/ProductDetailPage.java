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
        DisplayHelper.confirmDisplayMenu();
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu, product);
    }

    private static void displayTitle() {
        String title = PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static void displayBody(Product product) {
        System.out.println("|\t" + "Nama Produk\t\t\t" + "|\t" + product.getName() + DisplayHelper.calculateSpaceDisplay(product.getName(), 78) + "|");
        System.out.println("|\t" + "Kategori Produk\t\t" + "|\t" + product.getCategory() + DisplayHelper.calculateSpaceDisplay(product.getCategory(), 80) + "|");
        System.out.println("|\t" + "Harga Produk\t\t" + "|\tRp " + DisplayHelper.formatCurrency(product.getPrice() + "") + DisplayHelper.calculateSpaceDisplay(DisplayHelper.formatCurrency(product.getPrice() + ""), 73) + "|");
        System.out.println("|\t" + "Kuantitas Produk\t" + "|\t" + product.getQty() + " Produk Tersedia" + DisplayHelper.calculateSpaceDisplay(product.getQty() + " Produk Tersedia", 78) + "|");
        DisplayHelper.displayBorder("-");
    }

    private static void displayMenu() {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
        List<String> menus = Arrays.asList(
                "Masukkan Keranjang",
                "Beli Sekarang",
                "Lihat Keranjang",
                "Kembali"
        );
        DisplayHelper.displayMenu(menus);
    }

    public static void nextDisplay(int selectedMenu, Product product) {
        switch (selectedMenu) {
            case 1 : {
                System.out.print("Masukkan jumlah produk\t\t\t\t: ");
                Scanner input = new Scanner(System.in);
                int qty = input.nextInt();

                CartItem cartItem = new CartItem(product, qty);
                CartService.addToCart(cartItem);

                CartPage.display();
                break;
            }
            case 4 :
                HomePage.display(); break;
        }
    }
}
