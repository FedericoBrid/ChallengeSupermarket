package com.ChallengeSupermarket.ChallengeSupermarket.service;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.ProductDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.exception.NotFoundException;
import com.ChallengeSupermarket.ChallengeSupermarket.mapper.Mapper;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import com.ChallengeSupermarket.ChallengeSupermarket.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(Mapper::productToDTO).toList();
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        var prod = Product.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .amount(product.getAmount())
                .build();
        return Mapper.productToDTO(productRepository.save(prod));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO product) {
        Product prod = productRepository.findById(id).orElseThrow( ()-> new NotFoundException("Not found product"));
        prod.setName(product.getName());
        prod.setCategory(product.getCategory());
        prod.setPrice(product.getPrice());
        prod.setAmount(product.getAmount());
        return Mapper.productToDTO(productRepository.save(prod));
    }

    @Override
    public void deleteProduct(Long id) {
        Product prod = productRepository.findById(id).orElseThrow( ()-> new NotFoundException("The product cannot be deleted"));
        productRepository.deleteById(prod.getId());
    }
}
