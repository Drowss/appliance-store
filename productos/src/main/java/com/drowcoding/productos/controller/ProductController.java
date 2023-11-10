package com.drowcoding.productos.controller;

import com.drowcoding.productos.model.Product;
import com.drowcoding.productos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Value("${server.port}")
    private String svPort;

    @PostMapping("/new-product")
    public void createNewProducto(@RequestBody Product product){
        iProductService.createProduct(product);
    }

    @GetMapping("/id/{idProduct}")
    public Product getProduct(@PathVariable Integer idProduct){
        return iProductService.findProductById(idProduct);
    }

    @DeleteMapping("/delete/{idProduct}")
    public void deleteProduct(@PathVariable Integer idProduct){
        iProductService.deleteProduct(idProduct);
    }

    @GetMapping("/name/{productName}")
    public Product getProductByName(@PathVariable String productName){
        return iProductService.findProductByName(productName);
    }

}
