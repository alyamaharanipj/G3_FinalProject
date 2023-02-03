package com.binus.finalproject.service;
import com.binus.finalproject.model.Product;

import java.util.*;


public class ProductService {
    final int MAX_PRICE = 120;
    final int MIN_PRICE = 35;
    final int MAX_QTY = 50;
    final int MIN_QTY = 12;

    private List<Product> products = new ArrayList<>();
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void initProduct() {
        // List product
        List<String> productsName = Arrays.asList(
            "Lampu Sepeda LED Light",
            "Knee Support Brace",
            "Adjustable Hand Grip",
            "Tennis Racket",
            "Kettler Speed Jump",
            "Skipping Rope",
            "Treadmill Manual",
            "Yoga Matras",
            "Shuttlecock",
            "Gymball"
        );
        List<String> productsCategory = Arrays.asList(
                "Biking",
                "Running",
                "Tennis",
                "Tennis",
                "Jumping",
                "Jumping",
                "Gym",
                "Yoga",
                "Badminton",
                "Gym"
        );
        int i = 0;
        for (String productName: productsName) {
            float generatedPrice = getPrice();
            int generatedQty = getQty();
            Product product = new Product(productName, productsCategory.get(i), generatedPrice, generatedQty);
            getProducts().add(product);
            i++;
        }
    }

    public float getPrice () {
        return (float) Math.floor(Math.random() * (MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE) * 1000;
    }

    public int getQty () {
        return (int)Math.floor(Math.random() * (MAX_QTY - MIN_QTY + 1) + MIN_QTY);
    }

    public Product getProductById(int i) {
        return products.get(i - 1);
    }
}
