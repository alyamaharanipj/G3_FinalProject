package com.binus.finalproject.repository;

import com.binus.finalproject.model.Cart;
import com.binus.finalproject.model.CartItem;
import com.binus.finalproject.model.Product;
import com.binus.finalproject.model.Products;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CartRepository {
    public static Cart cart = new Cart();

    public static void add(CartItem cartItem) {
        cart.getCartItems().add(cartItem);
    }

    public static Cart getCart() {
        return cart;
    }

    public static CartItem getCartItemById(UUID id) {
        return getCart().getCartItems().stream().filter(cartItem -> cartItem.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public static UUID getProductId(CartItem cartItem) {
        return cartItem.getProduct().getId();
    }

    public static List<CartItem> getCartItems() {
        return getCart().getCartItems();
    }

    public static void addQty(int index, int qty) {
        getCart().getCartItems().get(index).addQty(qty);
    }

    public static int getCartQty(int index) {
        return getCart().getCartItems().get(index).getQty();
    }

//    public static CartItem getCartItemById(UUID id) {
//        return getCart().getCartItems().stream().filter(cart -> cart.getId().equals(id)).collect(Collectors.toList()).get(0);
//    }

    public static UUID getCartItemId(UUID productId) {
        int i = 0;
        for (CartItem cartItem: CartRepository.getCartItems()) {
            if(cartItem.getProduct().getId().equals(productId)){
                return cartItem.getId();
            } i++;
        } return new UUID(0,0);
    }

    public static int getCartItemIndex(UUID id) {
        int i = 0;
        for (CartItem cartItem: CartRepository.getCartItems()) {
            if(cartItem.getProduct().getId().equals(id)){
                return i;
            } i++;
        } return -1;
    }

    public static void deleteCartItem(CartItem cartItem) {
        getCart().getCartItems().remove(cartItem);
    }

    public static void clearCart() {
        cart = new Cart();
    }
}
