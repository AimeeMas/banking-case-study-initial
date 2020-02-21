package com.example.banking.controller;

import java.util.List;

public interface BasicController<T> {

    T add(T t);

    T get(Long id);

    T update(T t);

    boolean delete(T t);

    List<T> getAll();

}