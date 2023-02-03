package com.binus.finalproject.page;

import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductPage implements BasePage {
    ProductService productService = new ProductService();
    @Override
    public void display() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\tKATALOG PRODUK\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        productService.initProduct();
        List<Product> products = productService.getProducts();

        displayBorder("-");
        System.out.println("|\tNO" + "\t|\t\t\t\t" + "NAMA BARANG" + "\t\t\t\t|\t\t" + "KATEGORI" + "\t\t|\t\t" + "HARGA" + "\t\t|\t" + "STOK"+ "\t|");
        displayBorder("-");
        int i = 0;
        for (Product product : products) {
            i++;
            System.out.println("" +
                    "|"
                    + "\t" + i + "\t|\t\t" + product.getName()
                    + calculateSpaceDisplay(product.getName(), 33) + "|" + "\t\t" + product.getCategory()
                    + calculateSpaceDisplay(product.getCategory(), 17) + "|" + "\tRp " + formatCurrency(product.getPrice() + "")
                    + calculateSpaceDisplay(product.getPrice() + "", 14) + "|" + "\t" + product.getQty()
                    + calculateSpaceDisplay(product.getQty() + "", 10)  + "|");
            displayBorder("-");
        }
    }

    private String formatCurrency(String original) {
        String afterFormatting = "";
        int iterator = 1;
        for (int i = original.length() - 3; i >= 0; i--) {
            afterFormatting += original.toCharArray()[i];
            if(iterator % 3 == 0 && iterator!= 0 && i != 0)
                afterFormatting += ".";
            iterator++;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(afterFormatting);
        return builder.reverse().toString();
    }
    /*private void displayBorder() {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print("* ");
        System.out.println("");
    }*/
    private String calculateSpaceDisplay(String menu, int base) {
        int countedTab = (int) Math.round((double)(base - menu.length()) / 4.0);
        String tabPrinted = "";
        for(int i = 0; i < countedTab; i++)
            tabPrinted += "\t";
        return tabPrinted;
    }


    public void displayContinuousMenuProduct() {
        displayBorder("-");
        System.out.println("|\t\t\t\t\t\t\t\t\t\tMENU KATALOG PRODUK\t\t\t\t\t\t\t\t\t\t\t\t|");
        displayBorder("-");
        List<String> menus = Arrays.asList(
                "Lihat detail produk",
                "Masukkan Keranjang",
                "Beli Sekarang",
                "Kembali"
        );

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("|\t" + (i + 1) + "\t|\t" + menus.get(i) + displaySideBorder(menus.get(i)) + "|");
            displayBorder("-");
        }
    }

    public void getInputMenuUser () {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih salah satu menu katalog produk\t\t\t:\t");
        int selectedMenu = input.nextInt();

        ProductDetailPage productDetailPage = new ProductDetailPage();
        switch (selectedMenu){
            case 1 : {
                System.out.print("Pilih salah satu produk untuk melihat detail\t:\t");
                int selectedProductIndex = input.nextInt();
                Product selectedProduct = productService.getProductById(selectedProductIndex);
                productDetailPage.displayDetailProduct(selectedProduct);
                System.out.print("Tekan ENTER untuk melihat menu di detail produk");
                input.nextLine();
                input.nextLine();
                productDetailPage.displayContinuousMenuProductDetail();
                productDetailPage.getInputMenuUser();
                break;
            }
        }
    }
}
