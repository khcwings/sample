package com.multi.sample.persistence.service.common;

import com.multi.sample.persistence.models.common.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private JpaRepository<T, Long> repository;

    public BaseServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public void update(T entity) {
        repository.save(entity);
    }

    @Override
    public void create(T entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(T entity) {
        entity.setDeleted(true);
        update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        if (entity.isNew()) {
            create(entity);
        } else {
            update(entity);
        }
    }

    @Override
    public void create(Iterable<T> iterable) {
        repository.saveAll(iterable);
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void flush() {
        repository.flush();
    }

}