package com.binus.finalproject.service;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.repository.ProductRepository;
import java.util.*;

    public class ProductService {
        private static final int MAX_PRICE = 120;
        private static final int MIN_PRICE = 35;
        private static final int MAX_QTY = 50;
        private static final int MIN_QTY = 12;

        public static void initProduct() {
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
            for (String productName : productsName) {
                float generatedPrice = getPrice();
                int generatedQty = getQty();
                Product product = new Product(productName, productsCategory.get(i), generatedPrice, generatedQty);
                addProduct(product);
                i++;
            }
        }

        public static float getPrice() {
            return (float) Math.floor(Math.random() * (MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE) * 1000;
        }

        public static int getQty() {
            return (int) Math.floor(Math.random() * (MAX_QTY - MIN_QTY + 1) + MIN_QTY);
        }

        public static void addProduct(Product product) {
            ProductRepository.add(product);
        }

        public static List<Product> find() {
            return ProductRepository.getAllProducts().getProducts();
        }

        public static List<Product> findByName(String name) {
            return ProductRepository.getProductByName(name);
        }

        public static List<Product> findByCategory(String category) {
            return ProductRepository.getProductByCategory(category);
        }

        public static List<Product> findByBrand(String brand) {
            return ProductRepository.getProductByBrand(brand);
        }

        public static Product findByIdx(int i) {
            return ProductRepository.getProductByIndex(i);
        }
    }
