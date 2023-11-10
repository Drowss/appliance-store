package com.drowcoding.carrito.service;

import com.drowcoding.carrito.model.Cart;
import com.drowcoding.carrito.dto.ProductDTO;
import com.drowcoding.carrito.repository.ICartRepository;
import com.drowcoding.carrito.repository.IProductAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    @CircuitBreaker(name = "carrito-service", fallbackMethod = "fallbackFindCarrito")
    @Retry(name = "carrito-service")
    public Cart findCarrito(Integer idCarrito) {
//        createException();
        return iCartRepository.findById(idCarrito).orElse(null);
    }

    public Cart fallbackFindCarrito(Throwable throwable){
        return new Cart(-1, new ArrayList<>(), -1.0);
    }

    public void createException(){
        throw new IllegalArgumentException();
    }

    @Override
    public void addProductToCart(Integer idCart, Integer idProduct) {
        Cart cart = findCarrito(idCart);
        ProductDTO productDTO = iProductAPI.getProduct(idProduct);
        cart.getProductDTOList().add(productDTO.getName());
        cart.setTotalPrice(cart.getTotalPrice() + productDTO.getPrice());
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
