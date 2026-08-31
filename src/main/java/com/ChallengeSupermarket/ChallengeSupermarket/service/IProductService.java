package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO product);
    ProductDTO updateProduct(Long id, ProductDTO product);
    void deleteProduct(Long id);
}
