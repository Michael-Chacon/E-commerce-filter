package com.ecommerce.domain.service.customer;

import com.ecommerce.persistence.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface ICustomer {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    Optional<Customer> update(Long id, Customer customer);
    Optional<Customer> delete(Long id);
}
