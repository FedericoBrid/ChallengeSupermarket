package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
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
public class BranchService implements IBranchService{
    @Override
    public List<BranchDTO> getAllBranches() {
        return List.of();
    }

    @Override
    public BranchDTO createBranch(BranchDTO branch) {
        return null;
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branch) {
        return null;
    }

    @Override
    public void deleteBranch(Long id) {

    }
}
