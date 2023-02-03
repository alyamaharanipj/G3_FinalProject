package com.binus.finalproject.service;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;

import java.util.*;


public class CartService {
    private Cart cart = new Cart();
    private List<CartItem> cartItems = new ArrayList<>();
    private HashSet<UUID> productIds = new HashSet<>();

    public void addToCart(CartItem cartItem) {
        if(!productIds.contains(cartItem.getProduct().getId())) {
            cart.addCartItems(cartItem);
        } else {
            int productAddedIndex = cart.getCartItems().indexOf(cartItem.getProduct());
            cart.getCartItems().get(productAddedIndex).addQty(cartItem.getQty());
        }
    }

    public Cart getCart() {
        return cart;
    }
}
