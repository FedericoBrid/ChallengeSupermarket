package com.ChallengeSupermarket.ChallengeSupermarket.controller;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.BranchDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.dto.ProductDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.service.IBranchService;
import com.ChallengeSupermarket.ChallengeSupermarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private IBranchService branchService;

    @GetMapping
    public ResponseEntity<List<BranchDTO>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branch) {
        BranchDTO branchDTO = branchService.createBranch(branch);
        return ResponseEntity.created(URI.create("/api/branches/" + branchDTO.getId())).body(branchDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(@PathVariable Long id, @RequestBody BranchDTO branch) {
        BranchDTO branchDTO = branchService.updateBranch(id, branch);
        return ResponseEntity.ok(branchDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
