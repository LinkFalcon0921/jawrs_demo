package com.flincore.jawrs.jawrs_demo.services;

import com.flincore.jawrs.jawrs_demo.repositories.Repository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
abstract class ServiceSimple<ID, T> implements Service<ID, T>{
    @Inject
    protected Repository<ID, T> repository;
}
