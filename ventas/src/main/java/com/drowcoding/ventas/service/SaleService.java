package com.drowcoding.ventas.service;

import com.drowcoding.ventas.dto.CartDTO;
import com.drowcoding.ventas.model.Sale;
import com.drowcoding.ventas.repository.ICartAPI;
import com.drowcoding.ventas.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository iSaleRepository;

    @Autowired
    private ICartAPI iCartAPI;

    @Override
    public void createSale(Sale sale) {
        CartDTO cart = iCartAPI.cartDto(sale.getCart());
        sale.setTotalPrice(iCartAPI.totalPrice(cart.getIdCart()));
        iSaleRepository.save(sale);
    }

    @Override
    public void deleteSaleById(Integer idSale) {
        iSaleRepository.deleteById(idSale);
    }

    @Override
    public Sale findSaleById(Integer idSale) {
        return iSaleRepository.findById(idSale).orElse(null);
    }
}
