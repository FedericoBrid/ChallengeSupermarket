package com.ChallengeSupermarket.ChallengeSupermarket.dto;

import com.ChallengeSupermarket.ChallengeSupermarket.model.Branch;
import com.ChallengeSupermarket.ChallengeSupermarket.model.SaleDetail;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {
    private Long id;
    private LocalDate date;
    private String state;
    private Double total;
    //branch ID
    private Long branchId;
    //sale detail List
    private List<SaleDetailDTO> saleDetail;

}
