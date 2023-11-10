package com.drowcoding.productos.service;

import com.drowcoding.productos.model.Product;
import com.drowcoding.productos.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void createProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        iProductRepository.deleteById(idProduct);
    }

    @Override
    public Product findProductById(Integer idProduct) {
        return iProductRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Product findProductByName(String name) {
        return iProductRepository.getProductByName(name);
    }
}
