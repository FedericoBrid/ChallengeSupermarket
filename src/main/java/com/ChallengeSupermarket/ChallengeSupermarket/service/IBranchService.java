package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Branch;

import java.util.List;

public interface IBranchService {
    List<BranchDTO> getAllBranches();
    BranchDTO createBranch(BranchDTO branch);
    BranchDTO updateBranch(Long id, BranchDTO branch);
    void deleteBranch(Long id);
}
