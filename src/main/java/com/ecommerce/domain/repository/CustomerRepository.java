package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
    
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
