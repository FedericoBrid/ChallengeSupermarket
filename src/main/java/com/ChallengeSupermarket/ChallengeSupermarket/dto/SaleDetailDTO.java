package com.ChallengeSupermarket.ChallengeSupermarket.dto;

import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Sale;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailDTO {
    private Long id;
    //product
    private Long productId;
    private String productName;
    private Integer productAmount;
    private Double price;
    private Double subTotal;
}
