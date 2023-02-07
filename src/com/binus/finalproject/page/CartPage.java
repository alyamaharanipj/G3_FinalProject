package com.binus.finalproject.page;
import com.binus.finalproject.service.CartService;
import java.util.Arrays;
import java.util.List;

public class CartPage {

    private static final String PAGE_TITLE = "keranjang";

    public static void display() {
        displayTitle();
        if (CartService.find().size() == 0){
            displayMsgNotFound();
        } else {
            displayListCartItem();
        }

        DisplayHelper.confirmDisplayMenu();
        displayMenu();
        int selectedMenu = DisplayHelper.getMenuReq(PAGE_TITLE);
        nextDisplay(selectedMenu);
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
        List<String> menus = Arrays.asList(
                "Pesan Sekarang",
                "Kembali"
        );
        DisplayHelper.displayMenu(menus);
    }

    private static void nextDisplay (int selectedMenu) {
        switch (selectedMenu) {
            case 1 : {
                CustomerPage.display();
            }
            case 2 :
                HomePage.display(); break;
        }
    }

}
