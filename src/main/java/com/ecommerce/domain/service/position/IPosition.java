package com.ecommerce.domain.service.position;

import com.ecommerce.persistence.entity.Position;

import java.util.List;
import java.util.Optional;

public interface IPosition {
    List<Position> findAll();
    Optional<Position> findById(Long id);
    Position save(Position position);
    Optional<Position> update(Long id, Position position);
    Optional<Position> delete(Long id);
}
