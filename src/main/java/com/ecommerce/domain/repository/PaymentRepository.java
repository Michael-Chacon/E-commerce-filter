package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
