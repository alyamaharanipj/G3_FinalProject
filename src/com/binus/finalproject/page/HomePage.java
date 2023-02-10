package com.binus.finalproject.page;
import com.binus.finalproject.service.ProductService;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private static final String PAGE_TITLE = "utama";

    public static void init() {
        ProductService.initProduct();
    }

    public static void display() {
        displayTitle();
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu);
    }

    private static void displayTitle() {
        String title = "SELAMAT DATANG DI SPORT STORE GROUP 3 - DABA";
        DisplayHelper.displayHeader(title);
    }

    private static void displayMenu() {
        List<String> menus = Arrays.asList (
            "Lihat Katalog Produk",
            "Cari Produk Berdasarkan Nama Produk",
            "Cari Produk Berdasarkan Kategori",
            "Cari Produk Berdasarkan Brand",
            "Lihat Keranjang",
            "Keluar"
        );
        DisplayHelper.displayMenu(menus);
    }

    private static void nextDisplay (int selectedMenu) {
        switch (selectedMenu) {
            case 1 : {
                ProductPage.displayCatalogProduct();
                break;
            }
            case 2 : {
                String param = "nama";
                ProductPage.displayProductBy(param);
                break;
            }
            case 3 : {
                String param = "kategori";
                ProductPage.displayProductBy(param);
                break;
            }
            case 4 : {
                String param = "brand";
                ProductPage.displayProductBy(param);
                break;
            }
            case 5 : {
                CartPage.display();
                break;
            }
            case 6 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplay(selectedMenu);
            } break;
        }
    }
}
