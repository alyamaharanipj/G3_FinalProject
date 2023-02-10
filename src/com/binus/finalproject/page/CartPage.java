package com.binus.finalproject.page;
import com.binus.finalproject.service.CartService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {

    private static final String PAGE_TITLE = "keranjang";

    public static void display() {
        displayTitle();
        if (CartService.find().size() == 0) {
            displayMsgNotFound();
        } else {
            displayListCartItem();
        }
        DisplayHelper.confirmDisplayMenu(PAGE_TITLE);
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        if (CartService.find().size() == 0) {
            nextDisplayEmptyCart(selectedMenu);
        } else {
            nextDisplay(selectedMenu);
        }
    }

    private static void displayTitle() {
        String title = PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
    }

    private static void displayMsgNotFound() {
        String title = "Belum ada barang di keranjang";
        DisplayHelper.displayHeader(title);
    }

    private static void displayListCartItem() {
        DisplayHelper.displayTableCartItems();
    }

    private static void displayMenu() {
        String title = "MENU " + PAGE_TITLE.toUpperCase();
        DisplayHelper.displayHeader(title);
        List<String> menus = new ArrayList<>(Arrays.asList(
                "Pesan Sekarang",
                "Kembali",
                "Keluar"
        ));
        if (CartService.find().size() == 0) menus.remove(0);
        DisplayHelper.displayMenu(menus);
    }

    private static void nextDisplay (int selectedMenu) {
        switch (selectedMenu) {
            case 1 :
                CustomerPage.display(); break;
            case 2 :
                HomePage.display(); break;
            case 3 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplay(selectedMenu);
            } break;
        }
    }

    private static void nextDisplayEmptyCart (int selectedMenu) {
        switch (selectedMenu) {
            case 1 :
                HomePage.display(); break;
            case 2 :
                System.exit(0);
            default: {
                selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
                nextDisplayEmptyCart(selectedMenu);
            } break;
        }
    }
}
