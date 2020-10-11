package com.alehyem.personalfinances.dao;


import java.util.List;

public interface CrudDAO<T, ID> {
    List<T> findAll();

    T findById(ID id);

    void save(T object);

    T update(T object);

    void delete(T object);

    void deleteById(ID id);
}