package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDTO;

import java.util.List;

public interface ISaleService {

    List<SaleDTO> getAllSales();
    SaleDTO createSale(SaleDTO sale);
    SaleDTO updateSale(Long id, SaleDTO sale);
    void deleteSale(Long id);
}
