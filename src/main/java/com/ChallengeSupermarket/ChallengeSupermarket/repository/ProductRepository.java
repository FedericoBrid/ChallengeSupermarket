package com.ChallengeSupermarket.ChallengeSupermarket.repository;

import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
