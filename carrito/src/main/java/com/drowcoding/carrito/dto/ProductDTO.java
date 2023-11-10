package com.drowcoding.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
    private Integer idProduct;
    private String name;
    private String brand;
    private Double price;
}
