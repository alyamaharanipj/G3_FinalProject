package com.binus.finalproject.repository;

import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.model.Products;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

    public class ProductRepository {
        public static Products products = new Products();

        public static void add(Product product) {
            products.getProducts().add(product);
        }

        public static Products getAllProducts() {
            return products;
        }

        public static Product getProductByIndex(int i) {
            return products.getProducts().get(i - 1);
        }
        public static Product getProductById(UUID id) {
            return getAllProducts().getProducts().stream().filter(product -> product.getId().equals(id)).collect(Collectors.toList()).get(0);
        }
        public static List<Product> getProductByName(String name) {
            return getAllProducts().getProducts().stream().filter(product -> product.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        }

        public static List<Product> getProductByCategory(String category) {
            return getAllProducts().getProducts().stream().filter(product -> product.getCategory().contains(category)).collect(Collectors.toList());
        }

        public static List<Product> getProductByBrand(String brand) {
            return getAllProducts().getProducts().stream().filter(product -> product.getName().contains(brand)).collect(Collectors.toList());
        }
    }
