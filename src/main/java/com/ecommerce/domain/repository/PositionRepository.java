package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
