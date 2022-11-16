package com.flincore.jawrs.jawrs_demo.providers.hibernate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class JPAProvider {

    @PersistenceContext(name = "UsersPersist")
    private EntityManager manager;

    @Produces
    @RequestScoped
    public EntityManager beanEntityManager(){
        return this.manager;
    }
}
