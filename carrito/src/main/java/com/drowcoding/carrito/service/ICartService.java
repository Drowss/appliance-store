package com.drowcoding.carrito.service;

import com.drowcoding.carrito.model.Cart;

public interface ICartService {
    void createCarrito(Cart carrito);
    Cart findCarrito(Integer idCarrito);
    void addProductToCart(Integer idCart, Integer idProduct);
    void deleteProductFromCart(Integer idCart, Integer idProduct);
    double calculatePrice(Integer idCart);
}
