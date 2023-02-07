package com.binus.finalproject.service;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.repository.CartRepository;
import com.binus.finalproject.repository.ProductRepository;

import java.util.*;


public class CartService {
    private static final HashSet<UUID> productIds = new HashSet<>();

    public static void addToCart(CartItem cartItem) {
        if(!productIds.contains(CartRepository.getProductId(cartItem))) {
            CartRepository.add(cartItem);
        } else {
            int productAddedIndex = CartRepository.getCartItemIndex(cartItem.getProduct().getId());
            CartRepository.addQty(productAddedIndex, cartItem.getQty());
        }
        productIds.add(CartRepository.getProductId(cartItem));
    }

    public static List<CartItem> find() {
        return CartRepository.getCartItems();
    }
}
