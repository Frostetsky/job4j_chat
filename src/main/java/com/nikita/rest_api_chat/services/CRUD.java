package com.nikita.rest_api_chat.services;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    T saveOrUpdate(T entity);

    void delete(T entity);

    Optional<T> findById(int id);

    List<T> findAll();
}
