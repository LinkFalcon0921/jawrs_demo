package com.flincore.jawrs.jawrs_demo.repositories;

import java.util.List;

public interface Repository<ID, T> {

    List<T> getAll();

    T getById(ID id);

    T insert(T t);

    T update(T t);

    T delete(ID id);

}
