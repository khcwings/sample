package com.multi.sample.persistence.service.common;

import com.multi.sample.persistence.models.common.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    void update(T entity);

    void create(T entity);

    void delete(T entity);

    void saveOrUpdate(T entity);

    void create(Iterable<T> iterable);

    Optional<T> findById(Long id);

    List<T> findAll();

    Long count();

    void flush();
}