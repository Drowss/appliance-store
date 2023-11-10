package com.drowcoding.carrito.repository;

import com.drowcoding.carrito.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface IProductAPI {

    @GetMapping("/product/id/{idProducto}")
    ProductDTO getProduct(@PathVariable("idProducto") Integer idProducto);

    @GetMapping("/product/name/{productName}")
    ProductDTO getProductByName(@PathVariable("productName") String productName);
}
