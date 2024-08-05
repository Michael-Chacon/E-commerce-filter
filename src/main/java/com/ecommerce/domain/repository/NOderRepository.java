package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.NOrder;
import org.springframework.data.repository.CrudRepository;

public interface NOderRepository extends CrudRepository<NOrder, Long> {
}
