package com.ChallengeSupermarket.ChallengeSupermarket.controller;

import com.ChallengeSupermarket.ChallengeSupermarket.dto.ProductDTO;
import com.ChallengeSupermarket.ChallengeSupermarket.model.Product;
import com.ChallengeSupermarket.ChallengeSupermarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        ProductDTO prodDTO = productService.createProduct(product);
        return ResponseEntity.created(URI.create("/api/products/" + prodDTO.getId())).body(prodDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) {
        ProductDTO prodDTO = productService.updateProduct(id, product);
        return ResponseEntity.ok(prodDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
