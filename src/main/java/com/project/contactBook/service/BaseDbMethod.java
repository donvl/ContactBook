package com.project.contactBook.service;

import java.util.List;

public interface BaseDbMethod<T> {
    T finById(Long id);

    List<T> findAll();

    T create(T obj);

    void delete(T obj);

    void deleteById(Long id);

    void upDate(T obj);

}
