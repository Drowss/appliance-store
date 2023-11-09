package com.drowcoding.ventas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class CartDTO {
    private Integer idCart;
    private List<String> productDTOList;
    private Double totalPrice;
}
