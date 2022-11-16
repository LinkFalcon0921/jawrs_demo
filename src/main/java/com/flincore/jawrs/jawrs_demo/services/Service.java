package com.flincore.jawrs.jawrs_demo.services;

import jakarta.ejb.Local;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@Local
public interface Service<ID, T> {

    List<T> getEntities();

    Optional<T> getById(ID id);

    Optional<T> insert(T t);

    Optional<T> delete(ID id);

}
