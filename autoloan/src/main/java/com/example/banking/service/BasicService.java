package com.example.banking.service;

import java.util.List;

public interface BasicService<T> {

    boolean add(T t);

    T get(Long id);

    T update(T t);

    boolean delete(T t);

    List<T> getAll();
}