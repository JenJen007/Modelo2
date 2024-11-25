package org.example.repositorios;


import java.util.Set;

public interface BaseRepository<T> {
    void add(T entity);
    Set<T> findAll();
}