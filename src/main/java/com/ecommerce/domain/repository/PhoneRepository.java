package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
