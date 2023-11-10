package com.drowcoding.productos.service;

import com.drowcoding.productos.model.Product;

public interface IProductService {
    void createProduct(Product product);
    void deleteProduct(Integer idProduct);
    Product findProductById(Integer idProduct);
    Product findProductByName(String name);
}
