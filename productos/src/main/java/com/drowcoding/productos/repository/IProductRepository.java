package com.drowcoding.productos.repository;

import com.drowcoding.productos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT u FROM Product u WHERE u.name = :name")
    Product getProductByName(String name);
}
