package com.ecommerce.domain.service.position;

import com.ecommerce.domain.repository.PositionRepository;
import com.ecommerce.persistence.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PositionImpl implements IPosition{

    @Autowired
    private PositionRepository repository;
    @Transactional(readOnly = true)
    @Override
    public List<Position> findAll() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Position> findById(Long id) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Position save(Position position) {
        return null;
    }

    @Transactional
    @Override
    public Optional<Position> update(Long id, Position position) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Position> delete(Long id) {
        return Optional.empty();
    }
}
