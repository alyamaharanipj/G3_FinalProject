package com.binus.finalproject.service;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.repository.CartRepository;
import com.binus.finalproject.repository.ProductRepository;

import java.util.*;


public class CartService {
    private static final HashSet<UUID> productIds = new HashSet<>();

    public static boolean addToCart(CartItem cartItem) {
        if(!productIds.contains(CartRepository.getProductId(cartItem))) {
            if(cartItem.getQty() > cartItem.getProduct().getQty())
                return false;
            CartRepository.add(cartItem);
        } else {
            int productAddedIndex = CartRepository.getCartItemIndex(cartItem.getProduct().getId());
            if (CartRepository.getCartQty(productAddedIndex) + cartItem.getQty() > cartItem.getProduct().getQty())
                return false;
            CartRepository.addQty(productAddedIndex, cartItem.getQty());
        }
        productIds.add(CartRepository.getProductId(cartItem));
        return true;
    }

    public static void clearCart() {
        CartRepository.clearCart();
    }

    public static List<CartItem> find() {
        return CartRepository.getCartItems();
    }
}
