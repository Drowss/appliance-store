package com.drowcoding.ventas.controller;

import com.drowcoding.ventas.model.Sale;
import com.drowcoding.ventas.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService iSaleService;

    @PostMapping("/new-sale")
    public void createSale(@RequestBody Sale sale){
        iSaleService.createSale(sale);
    }

    @GetMapping("/id/{idSale}")
    public Sale findSaleById(@PathVariable Integer idSale){
        return iSaleService.findSaleById(idSale);
    }

    @DeleteMapping("/delete/{idSale}")
    public void deleteById(@PathVariable Integer idSale){
        iSaleService.deleteSaleById(idSale);
    }
}
