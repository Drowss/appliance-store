package com.drowcoding.carrito.controller;

import com.drowcoding.carrito.model.Cart;
import com.drowcoding.carrito.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CarritoController {

    @Autowired
    private ICartService iCartService;

    @Value("${server.port}")
    private String svPort;

    @GetMapping("/{idCart}")
    public Cart findCart(@PathVariable Integer idCart){
        System.out.println("Estamos en " + svPort);
        return iCartService.findCarrito(idCart);
    }

    @PostMapping("/create")
    public void crearCart(@RequestBody Cart cart){
        iCartService.createCarrito(cart);
    }

    @PutMapping("/add")
    public void addProductToCart(@RequestParam Integer idCart, @RequestParam Integer idProduct){
        iCartService.addProductToCart(idCart, idProduct);
    }

    @PutMapping("/delete")
    public void deleteProducFromCart(@RequestParam Integer idCart, @RequestParam Integer idProduct){
        iCartService.deleteProductFromCart(idCart, idProduct);
    }

    @GetMapping("/purchase")
    public double purchaseItems(@RequestParam Integer idCart){
        return iCartService.calculatePrice(idCart);
    }
}
