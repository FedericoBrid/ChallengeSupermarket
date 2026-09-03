package com.ChallengeSupermarket.ChallengeSupermarket.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "saleId")
    private Sale sale;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "productId")
    private Product product;
    private Integer productAmount;
    private Double price;
}
