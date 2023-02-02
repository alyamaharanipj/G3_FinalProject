package com.binus.finalproject.service;

import com.binus.finalproject.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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
        List<String> productsName = Arrays.asList("Pashmina", "Hijab Instan", "Bergo", "Khimar", "Hijab Sport", "Hijab Scarf");
        List<String> productsCategory = Arrays.asList("Medium", "Large");
        for (String productName: productsName) {
            float generatedPrice = getPrice();
            int generatedQty = getQty();
            Random rand = new Random();
            String selectedCategory = productsCategory.get(rand.nextInt(productsCategory.size()));
            Product product = new Product(productName, selectedCategory, generatedPrice, generatedQty);
            getProducts().add(product);
        }
    }

    public float getPrice () {
        return (float) Math.floor(Math.random() * (MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE) * 1000;
    }

    public int getQty () {
        return (int)Math.floor(Math.random() * (MAX_QTY - MIN_QTY + 1) + MIN_QTY);
    }
}
