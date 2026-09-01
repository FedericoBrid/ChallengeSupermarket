package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.exception.NotFoundException;
import com.ChallengeSupermarket.ChallengeSupermarket.mapper.Mapper;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Branch;
import com.ChallengeSupermarket.ChallengeSupermarket.repository.BranchRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchService implements IBranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll().stream().map(Mapper::branchToDTO).toList();
    }

    @Override
    public BranchDTO createBranch(BranchDTO branch) {
        Branch bran = Branch.builder()
                .name(branch.getName())
                .address(branch.getAddress())
                .build();
        return Mapper.branchToDTO(branchRepository.save(bran));
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branch) {
        Branch bran = branchRepository.findById(id).orElseThrow(() -> new NotFoundException("Branch not found"));
        bran.setName(branch.getName());
        bran.setAddress(branch.getAddress());
        return Mapper.branchToDTO(branchRepository.save(bran));
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.findById(id).orElseThrow(() -> new NotFoundException("Branch not found"));
        branchRepository.deleteById(id);
    }
}
