package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDetailDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.exception.NotFoundException;
import com.ChallengeSupermarket.ChallengeSupermarket.mapper.Mapper;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Branch;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Sale;
import com.ChallengeSupermarket.ChallengeSupermarket.model.SaleDetail;
import com.ChallengeSupermarket.ChallengeSupermarket.repository.BranchRepository;
import com.ChallengeSupermarket.ChallengeSupermarket.repository.ProductRepository;
import com.ChallengeSupermarket.ChallengeSupermarket.repository.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleService implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream().map(Mapper::saleToDTO).toList();
    }

    @Override
    public SaleDTO createSale(SaleDTO sale) {

        if (sale == null)
            throw new NotFoundException("Sale is null");

        if (sale.getBranchId() == null)
            throw new NotFoundException("Branch is null");

        if (sale.getSaleDetail() == null || sale.getSaleDetail().isEmpty())
            throw new NotFoundException("Sale detail is null");

        //obtain branch by ID
        Branch branch = branchRepository.findById(sale.getBranchId())
                .orElseThrow(() -> new NotFoundException("Branch not found"));

        //create sale
        Sale saleEntity = Sale.builder()
                .date(sale.getDate())
                .state(sale.getState())
                .branch(branch)
                .total(sale.getTotal())
                .build();

        //create sale details
        List<SaleDetail> saleDetailList = new ArrayList<>();

        double totalCalculated = 0.0;

        for (SaleDetailDTO detail : sale.getSaleDetail()) {

            Product product = productRepository.findById(detail.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            SaleDetail saleDetail = SaleDetail.builder()
                    .sale(saleEntity)
                    .product(product)
                    .productAmount(detail.getProductAmount())
                    .price(detail.getPrice())
                    .build();

            saleDetailList.add(saleDetail);
            totalCalculated = totalCalculated + (detail.getPrice() * detail.getProductAmount());
        }

        saleEntity.setSaleDetail(saleDetailList);
        saleEntity.setTotal(totalCalculated);
        Sale savedSale = saleRepository.save(saleEntity);
        return Mapper.saleToDTO(savedSale);
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO sale) {
        Sale saleToUpdated = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("Sale not found"));
        if (sale.getDate() != null) {
            saleToUpdated.setDate(sale.getDate());
        }
        if (sale.getState() != null) {
            saleToUpdated.setState(sale.getState());
        }
        if (sale.getTotal() != null) {
            saleToUpdated.setTotal(sale.getTotal());
        }
        if (sale.getBranchId() != null) {
            Branch branch = branchRepository.findById(sale.getBranchId())
                    .orElseThrow(() -> new NotFoundException("Branch not found"));
            saleToUpdated.setBranch(branch);
        }
        Sale updatedSale = saleRepository.save(saleToUpdated);
        return Mapper.saleToDTO(updatedSale);
    }

    @Override
    public void deleteSale(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new NotFoundException("Sale not found"));
        saleRepository.delete(sale);
    }
}
