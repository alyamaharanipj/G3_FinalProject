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
        List<Product> products = displayAllProduct();
        DisplayHelper.confirmDisplayMenu(PAGE_TITLE);
        displayMenu(products.size());
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        if (products.size() == 0) {
            nextDisplayEmptyProduct(selectedMenu, products);
        } else {
            nextDisplay(selectedMenu, products);
        }
    }

    public static void displayProductBy(String param) {
        displayTitleSearchProductBy(param);
        String productName = filterProductReq(param);
        List<Product> products = displayFilterProduct(param, productName);
        DisplayHelper.confirmDisplayMenu(PAGE_TITLE);
        displayMenu(products.size());
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        if (products.size() == 0) {
            nextDisplayEmptyProduct(selectedMenu, products);
        } else {
            nextDisplay(selectedMenu, products);
        }
    }

    private static void displayTitleCatalogProduct() {
        DisplayHelper.displayHeader(PAGE_TITLE.toUpperCase());
    }

    private static void displayTitleSearchProductBy(String param) {
        String title = "CARI PRODUK BERDASARKAN " + param.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static List<Product> displayAllProduct() {
        List<Product> products = ProductService.find();
        displayListProduct(products);
        return products;
    }

    private static List<Product> displayFilterProduct(String type, String value) {
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
        return products;
    }

    private static void displayListProduct(List<Product> products) {
        DisplayHelper.displayTableProduct(products);
    }

    private static void displayMsgNotFound() {
        String title = "Produk yang anda cari tidak ditemukan";
        DisplayHelper.displayHeader(title);
    }

    private static void displayMenu(int size) {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
        List<String> menus = new ArrayList<>(Arrays.asList(
                "Lihat detail produk",
                "Masukkan keranjang",
                "Kembali",
                "Keluar"
        ));
        if(size == 0) {
            menus.remove(0);
            menus.remove(0);
        }
        DisplayHelper.displayMenu(menus);
    }

    private static String filterProductReq(String param) {
        System.out.print("Masukkan " + param + " produk untuk dicari\t: ");
        Scanner input = new Scanner(System.in);
        String productReq = input.next();
        return productReq;
    }

    private static void nextDisplay(int selectedMenu, List<Product> products) {
        switch (selectedMenu) {
            case 1 : {
                boolean isValidIdx = false;
                int selectedProductIndex = 0;
                while(!isValidIdx) {
                    System.out.print("Pilih salah satu nomor produk untuk melihat detail atau tekan 0 untuk kembali ke menu\t:\t");
                    Scanner input = new Scanner(System.in);
                    selectedProductIndex = input.nextInt();
                    if(selectedProductIndex >= 1 && selectedProductIndex <= products.size())
                        isValidIdx = true;
                    else if (selectedProductIndex == 0) {
                        displayMenu(products.size());
                        selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                        nextDisplay(selectedMenu, products);
                    }
                    else
                        System.out.println("Masukkan nomor produk dengan benar!");
                }

                ProductDetailPage.display(products.get(selectedProductIndex - 1));
            } break;
            case 2 : {
                boolean isValidIdx = false;
                int selectedProductIndex = 0;
                Scanner input = new Scanner(System.in);
                while(!isValidIdx) {
                    System.out.print("Pilih salah satu nomor produk untuk dimasukkan ke keranjang atau tekan 0 untuk kembali ke menu\t:\t");
                    selectedProductIndex = input.nextInt();
                    if(selectedProductIndex >= 1 && selectedProductIndex <= products.size())
                        isValidIdx = true;
                    else if (selectedProductIndex == 0) {
                        displayMenu(products.size());
                        selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                        nextDisplay(selectedMenu, products);
                    }
                    else
                        System.out.println("Masukkan nomor produk dengan benar!");
                }
                Product selectedProduct = products.get(selectedProductIndex - 1);
                boolean isValidQty = false;
                while(!isValidQty) {
                    System.out.print("Masukkan jumlah produk\t\t\t\t: ");
                    int qty = input.nextInt();
                    CartItem cartItem = new CartItem(selectedProduct, qty);
                    isValidQty = CartService.addToCart(cartItem);
                }
                CartPage.display();
            } break;
            case 3 :
                HomePage.display(); break;
            case 4 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplay(selectedMenu, products);
            } break;

        }
    }

    private static void nextDisplayEmptyProduct(int selectedMenu, List<Product> products) {
        switch (selectedMenu) {
            case 1 :
                HomePage.display(); break;
            case 2 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplay(selectedMenu, products);
            }

        }
    }
}
