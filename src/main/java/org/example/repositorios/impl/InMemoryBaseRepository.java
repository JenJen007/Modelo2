package org.example.repositorios.impl;

import org.example.repositorios.BaseRepository;

import java.util.HashSet;
import java.util.Set;

public class InMemoryBaseRepository<T> implements BaseRepository<T> {
    protected Set<T> entities = new HashSet<>();

    @Override
    public void add(T entity) {
        entities.add(entity);
    }

    @Override
    public Set<T> findAll() {
        return entities;
    }
}
