package com.binus.finalproject.page;

import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.CartService;
import com.binus.finalproject.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    public static void displayCatalogProduct() {
        ProductPage.displayCatalogProduct();
    }

    public static void displayProductByName() {
        String param = "nama";
        ProductPage.displayProductBy(param);
    }

    public static void displayProductByCategory() {
        String param = "brand";
        ProductPage.displayProductBy(param);
    }

    public static void displayProductByBrand() {
        String param = "brand";
        ProductPage.displayProductBy(param);
    }

    public static void displayCart() {
        CartPage.display();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void displayProductDetail() {
        System.out.print("Pilih salah satu produk untuk melihat detail\t:\t");
        Scanner input = new Scanner(System.in);
        int selectedProductIndex = input.nextInt();
        Product selectedProduct = ProductService.findByIdx(selectedProductIndex);
        ProductDetailPage.display(selectedProduct);
    }

    public static void displayAddToCart() {
        System.out.print("Pilih salah satu produk untuk dimasukkan ke keranjang\t:\t");
        Scanner input = new Scanner(System.in);
        int selectedProductIndex = input.nextInt();
        Product selectedProduct = ProductService.findByIdx(selectedProductIndex);
        boolean isValidQty = false;
        while(!isValidQty) {
            System.out.print("Masukkan jumlah produk\t\t\t\t: ");
            int qty = input.nextInt();
            CartItem cartItem = new CartItem(selectedProduct, qty);
            isValidQty = CartService.addToCart(cartItem);
        }
        CartPage.display();
    }

    public static void displayHome() {
        HomePage.display();
    }

}
