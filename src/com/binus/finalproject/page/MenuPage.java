package com.binus.finalproject.page;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuPage implements BasePage {

    private CustomerPage customerPage = new CustomerPage();
    @Override
    public void display() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\tSELAMAT DATANG DI SPORT STORE GROUP 3 - DABA\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        //customerPage.display();
        displayMenu();
        getInputMenuUser();
    }

    /*private void displayBorder() {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print("* ");
        System.out.println("");
    }*/

    private void displayMenu() {
        List<String> menus = Arrays.asList (
            "Lihat Katalog Produk",
            "Cari Produk Berdasarkan Nama Produk",
            "Cari Produk Berdasarkan Kategori",
            "Cari Produk Berdasarkan Brand",
            "Lihat Keranjang"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("|\t" + (i + 1) + "\t|\t" + menus.get(i) + displaySideBorder(menus.get(i)) + "|");
            displayBorder("-");
        }
    }



    private void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu : ");
        int selectedMenu = input.nextInt();

        ProductPage productPage = new ProductPage();
        switch (selectedMenu){
            case 1 : {
                productPage.display();
                System.out.print("Tekan ENTER untuk melihat menu di katalog produk");
                input.nextLine();
                input.nextLine();
                productPage.displayContinuousMenuProduct();
                productPage.getInputMenuUser();
                break;
            }
        }
    }
}
