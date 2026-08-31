package com.ChallengeSupermarket.ChallengeSupermarket.mapper;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.ProductDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.SaleDetailDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Branch;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    //map product to productDTO
    public static ProductDTO productToDTO(Product product){
        if (product == null){
            return null;
        }
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .amount(product.getAmount())
                .build();
    }
    //map sale to saleDTO
    public static SaleDTO saleToDTO(Sale sale){
        if (sale == null){
            return null;
        }
        var detail = sale.getSaleDetail().stream().map(sd ->
            SaleDetailDTO.builder()
                    .id(sd.getId())
                    .productName(sd.getProduct().getName())
                    .productAmount(sd.getProductAmount())
                    .price(sd.getPrice())
                    .subTotal(sd.getPrice() * sd.getProductAmount())
                    .build()
        ).toList();
        var total = detail.stream()
                .map(SaleDetailDTO::getSubTotal)
                .reduce(0.0, Double::sum);
        return SaleDTO.builder()
                .id(sale.getId())
                .date(sale.getDate())
                .state(sale.getState())
                .total(total)
                .branchId(sale.getBranch().getId())
                .saleDetail(detail)
                .build();
    }

    //map branch to branchDTO
    public static BranchDTO branchToDTO(Branch branch){
        if (branch == null){
            return null;
        }
        return BranchDTO.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .build();
    }
}
