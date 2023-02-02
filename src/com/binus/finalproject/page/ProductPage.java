package com.binus.finalproject.page;

import com.binus.finalproject.model.Product;
import com.binus.finalproject.service.ProductService;

import java.util.List;

public class ProductPage implements BasePage {
    @Override
    public void display() {
        ProductService productService = new ProductService();
        productService.initProduct();
        List<Product> products = productService.getProducts();

        System.out.println("==========================================================================================================");
        System.out.println("||\tNO" + "\t||\t\t" + "NAMA BARANG" + "\t\t||\t\t" + "KATEGORI" + "\t\t||\t\t" + "HARGA" + "\t\t\t||\t\t" + "STOK"+ "\t\t\t||");
        System.out.println("==========================================================================================================");
        int i = 0;
        for (Product product : products) {
            i++;
            System.out.println("" +
                    "||"
                    + "\t" + i + "\t||"
                    + calculateSpaceDisplay(product.getName())
                    + calculateSpaceDisplay(product.getCategory())
                    + calculateSpaceDisplay(product.getPrice() + "")
                    + calculateSpaceDisplay(product.getQty() + ""));
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }

    private String calculateSpaceDisplay(String item) {
        return "\t" + item + (item.length() <= 3 ? "\t\t\t" : (item.length() > 3 && item.length() <= 7 ? "\t\t" : item.length() >= 12 ? "" : "\t")) + "\t\t||";
    }
}
