package com.drowcoding.ventas.model;

import com.drowcoding.ventas.dto.CartDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;
    @Temporal(TemporalType.DATE)
    private LocalDate dateSale;
    private Integer cart;
    private Double totalPrice;
}
