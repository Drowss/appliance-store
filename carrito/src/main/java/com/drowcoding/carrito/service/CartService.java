package com.drowcoding.carrito.service;

import com.drowcoding.carrito.model.Cart;
import com.drowcoding.carrito.dto.ProductDTO;
import com.drowcoding.carrito.repository.ICartRepository;
import com.drowcoding.carrito.repository.IProductAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private IProductAPI iProductAPI;

    @Override
    public void createCarrito(Cart carrito) {
        iCartRepository.save(carrito);
    }

    @Override
    public Cart findCarrito(Integer idCarrito) {
        return iCartRepository.findById(idCarrito).orElse(null);
    }

    @Override
    public void addProductToCart(Integer idCart, Integer idProduct) {
        Cart cart = findCarrito(idCart);
        ProductDTO productDTO = iProductAPI.getProduct(idProduct);
        cart.getProductDTOList().add(productDTO.getName());
        this.createCarrito(cart);
    }

    @Override
    public void deleteProductFromCart(Integer idCart, Integer idProduct) {
        Cart cart = findCarrito(idCart);
        ProductDTO productDTO = iProductAPI.getProduct(idProduct);
        cart.getProductDTOList().remove(productDTO.getName());
        this.createCarrito(cart);
    }

    @Override
    public double calculatePrice(Integer idCart) {
        double helper = 0;
        Cart cart = findCarrito(idCart);
        for (String item : cart.getProductDTOList()){
            helper += iProductAPI.getProductByName(item).getPrice();
        }
        cart.setTotalPrice(helper);

        return helper;
    }
}
