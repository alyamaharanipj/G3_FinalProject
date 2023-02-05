package com.binus.finalproject.page;
import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.Products;
import com.binus.finalproject.service.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuPage implements BasePage {
    private CustomerPage customerPage = new CustomerPage();
    Products products = new Products();
    CartPage cartPage = new CartPage();
    Cart cart = new Cart();
    ProductService productService = new ProductService();
    @Override
    public void display() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\tSELAMAT DATANG DI SPORT STORE GROUP 3 - DABA\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        displayMenu();
        getInputMenuUser();
    }

    public void init() {
        productService.initProduct(products);
    }

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
                productPage.display(products);
                System.out.print("Tekan ENTER untuk melihat menu di katalog produk");
                input.nextLine();
                input.nextLine();
                productPage.displayContinuousMenuProduct();
                productPage.getInputMenuUser();
                break;
            }
            case 2 : {
                productPage.displaySearchProductByName(products); break;
            }
            case 5 : {
                cartPage.displayDetailCart(cart);
                System.out.print("Tekan ENTER untuk melihat menu di keranjang");
                input.nextLine();
                input.nextLine();
                cartPage.displayContinuousMenuProductDetail();
                cartPage.getInputMenuUser();
            }
        }
    }
}
