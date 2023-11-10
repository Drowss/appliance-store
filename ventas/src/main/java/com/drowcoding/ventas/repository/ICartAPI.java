package com.drowcoding.ventas.repository;

import com.drowcoding.ventas.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "carrito-service")
public interface ICartAPI {

    @GetMapping("/cart/purchase")
    public Double totalPrice(@RequestParam Integer idCart);

    @GetMapping("/cart/{idCart}")
    CartDTO cartDto(@PathVariable Integer idCart);
}
