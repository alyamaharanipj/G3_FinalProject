package com.binus.finalproject.service;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.repository.CartRepository;
import com.binus.finalproject.repository.ProductRepository;

import java.util.*;

    public class ProductService {
        private static final int MAX_PRICE = 120;
        private static final int MIN_PRICE = 35;
        private static final int MAX_QTY = 50;
        private static final int MIN_QTY = 12;

        public static void initProduct() {
            String[] productsName = {
                    "Lampu Sepeda LED Light","Knee Support Brace","Adjustable Hand Grip",
                    "Tennis Racket","Kettler Speed Jump","Skipping Rope","Treadmill Manual",
                    "Yoga Matras","Shuttlecock","Gymball" } ;
            String[] productsCategory = { "Biking","Running","Tennis","Tennis",
                    "Jumping","Jumping","Gym","Yoga","Badminton","Gym"};
            String[] productsBrand = {"ADIDAS", "NIKE", "REEBOK", "SKECHERS", "DIADORA"};
            int i = 0;
            for (String productName : productsName) {
                float generatedPrice = getPrice();
                int generatedQty = getQty();
                String generatedBrand = getBrand(productsBrand);
                // Instansiasi produk
                Product product = new Product(productName, productsCategory[i], generatedBrand,
                        generatedPrice, generatedQty);
                addProduct(product);
                i++;
            }
        }

        public static float getPrice() { return (float) Math.floor(Math.random() * (MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE) * 1000; }

        public static int getQty() {
            return (int) Math.floor(Math.random() * (MAX_QTY - MIN_QTY + 1) + MIN_QTY);
        }

        public static String getBrand(String[] productsBrand) {
            Random rand = new Random();
            return productsBrand[rand.nextInt(productsBrand.length)];
        }

        public static void addProduct(Product product) { ProductRepository.add(product); }

        public static List<Product> find() {
            return ProductRepository.getAllProducts().getProducts();
        }

        public static List<Product> findByName(String name) {
            return ProductRepository.getProductByName(name);
        }

        public static List<Product> findByCategory(String category) { return ProductRepository.getProductByCategory(category);}

        public static List<Product> findByBrand(String brand) {
            return ProductRepository.getProductByBrand(brand);
        }

        public static Product findByIdx(int i) { return ProductRepository.getProductByIndex(i); }

        private static int getQty (Product product) {
            return ProductRepository.getProductQty(product);
        }

        public static void updateQty() {
            List<CartItem> cartItem = CartService.find();
            for (CartItem item : cartItem) {
                Product product = ProductRepository.getProductById(CartRepository.getProductId(item));
                int newQty = decreaseQty(getQty(product), item.getQty());
                ProductRepository.setProductQty(product, newQty);
            }
        }

        private static int decreaseQty(int currentQty, int soldQty) {
            return currentQty - soldQty;
        }
    }
