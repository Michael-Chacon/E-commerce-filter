package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
