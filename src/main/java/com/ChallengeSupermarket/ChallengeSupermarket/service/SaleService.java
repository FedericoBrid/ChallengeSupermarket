package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleService implements ISaleService{
    @Override
    public List<SaleDTO> getAllSales() {
        return List.of();
    }

    @Override
    public SaleDTO createSale(SaleDTO sale) {
        return null;
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO sale) {
        return null;
    }

    @Override
    public void deleteSale(Long id) {

    }
}
