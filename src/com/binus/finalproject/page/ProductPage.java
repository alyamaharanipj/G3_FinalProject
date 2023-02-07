package com.binus.finalproject.page;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.CartService;
import com.binus.finalproject.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductPage {
    private static final String PAGE_TITLE = "katalog produk";

    public static void displayCatalogProduct() {
        displayTitleCatalogProduct();
        displayAllProduct();
        DisplayHelper.confirmDisplayMenu();
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu);
    }

    public static void displayProductBy(String param) {
        displayTitleSearchProductBy(param);
        String productName = filterProductReq(param);
        displayFilterProduct(param, productName);
        DisplayHelper.confirmDisplayMenu();
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu);
    }

    private static void displayTitleCatalogProduct() {
        DisplayHelper.displayHeader(PAGE_TITLE.toUpperCase());
    }

    private static void displayTitleSearchProductBy(String param) {
        String title = "CARI PRODUK BERDASARKAN " + param.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static void displayAllProduct() {
        List<Product> products = ProductService.find();
        displayListProduct(products);
    }

    private static void displayFilterProduct(String type, String value) {
        List<Product> products = new ArrayList<>();
        switch (type) {
            case "nama" : {
                products = ProductService.findByName(value);
                break;
            }
            case "kategori" : {
                products = ProductService.findByCategory(value);
                break;
            }
            case "brand" : {
                products = ProductService.findByBrand(value);
                break;
            }
        }

        if(products.size() != 0) {
            displayListProduct(products);
        } else {
            displayMsgNotFound();
        }
    }

    private static void displayListProduct(List<Product> products) {
        DisplayHelper.displayTableProduct(products);
    }

    private static void displayMsgNotFound() {
        String title = "Produk yang anda cari tidak ditemukan";
        DisplayHelper.displayHeader(title);
    }

    private static void displayMenu() {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
        List<String> menus = Arrays.asList(
            "Lihat detail produk",
            "Masukkan Keranjang",
            "Beli Sekarang",
            "Kembali"
        );
        DisplayHelper.displayMenu(menus);
    }

    private static String filterProductReq(String param) {
        System.out.print("Masukkan " + param + " produk untuk dicari\t: ");
        Scanner input = new Scanner(System.in);
        String productReq = input.next();
        return productReq;
    }

    private static void nextDisplay(int selectedMenu) {
        switch (selectedMenu) {
            case 1 : {
                System.out.print("Pilih salah satu produk untuk melihat detail\t:\t");
                Scanner input = new Scanner(System.in);
                int selectedProductIndex = input.nextInt();

                Product selectedProduct = ProductService.findByIdx(selectedProductIndex);
                ProductDetailPage.display(selectedProduct);
                break;
            }
            case 2 : {
                System.out.print("Pilih salah satu produk untuk dimasukkan ke keranjang\t:\t");
                Scanner input = new Scanner(System.in);
                int selectedProductIndex = input.nextInt();
                Product selectedProduct = ProductService.findByIdx(selectedProductIndex);

                System.out.print("Masukkan jumlah produk\t\t\t\t: ");
                int qty = input.nextInt();

                CartItem cartItem = new CartItem(selectedProduct, qty);
                CartService.addToCart(cartItem);

                CartPage.display();
            }
            case 4 :
                HomePage.display(); break;
        }
    }
}
