package com.ecommerce.web.controller;

import com.ecommerce.domain.service.product.IProduct;
import com.ecommerce.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProduct service;

    @GetMapping
    public List<Product> listProducts() {
        return service.findAll();
    }

    @GetMapping("/{id]")
    public ResponseEntity<Product> view(@PathVariable Long id) {
        Optional<Product> productOpt = service.findById(id);
        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id]")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOpt = service.update(id, product);
        if (productOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product product = new Product();
        product.setId(id);
        Optional<Product> productOpt = service.delete(id);
        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
