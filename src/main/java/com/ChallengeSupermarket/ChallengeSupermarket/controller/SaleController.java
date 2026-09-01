package com.ChallengeSupermarket.ChallengeSupermarket.controller;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.service.IBranchService;
import com.ChallengeSupermarket.ChallengeSupermarket.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO sale) {
        SaleDTO saleDTO = saleService.createSale(sale);
        return ResponseEntity.created(URI.create("/api/sales/" + saleDTO.getId())).body(saleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @RequestBody SaleDTO sale) {
        SaleDTO saleDTO = saleService.updateSale(id, sale);
        return ResponseEntity.ok(saleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
