package com.drowcoding.ventas.service;

import com.drowcoding.ventas.model.Sale;

public interface ISaleService {
    void createSale(Sale sale);
    void deleteSaleById(Integer idSale);
    Sale findSaleById(Integer idSale);
}
