package com.flincore.jawrs.jawrs_demo.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

abstract class RepositorySimple<T> implements Repository<Long, T>{

    @Inject
    protected EntityManager manager;

    protected Class<T> classEntity;

}
