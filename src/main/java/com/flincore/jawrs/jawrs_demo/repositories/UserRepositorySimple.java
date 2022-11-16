package com.flincore.jawrs.jawrs_demo.repositories;

import com.flincore.jawrs.jawrs_demo.models.User;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
import java.util.Objects;

@RequestScoped
public class UserRepositorySimple extends RepositorySimple<User> {

    public UserRepositorySimple() {
        this.classEntity = User.class;
    }

    @Override
    public List<User> getAll() {
        return manager
                .createQuery("SELECT u FROM User u", this.classEntity)
                .getResultList();
    }

    @Override
    public User getById(Long id) {
        return this.manager.find(this.classEntity, id);
    }

    @Override
    public User insert(User user) {
        this.manager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        this.manager.merge(user);
        return user;
    }

    @Override
    public User delete(Long id) {
        User userDeleted = this.getById(id);
        if (Objects.nonNull(userDeleted)) {
            this.manager.remove(userDeleted);
        }
        return userDeleted;
    }
}
