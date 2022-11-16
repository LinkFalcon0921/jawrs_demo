package com.flincore.jawrs.jawrs_demo.services;

import com.flincore.jawrs.jawrs_demo.models.User;
import com.flincore.jawrs.jawrs_demo.repositories.UserRepositorySimple;
import jakarta.ejb.Stateless;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceSimple extends ServiceSimple<Long, User> implements Service<Long, User> {

    @Override
    public List<User> getEntities() {
        return this.repository.getAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(this.repository.getById(id));
    }

    @Override
    public Optional<User> insert(User user) {
        if (Objects.nonNull(user.getId())) {
            this.repository.update(user);
        } else {
            this.repository.insert(user);
        }

        return Optional.of(user);
    }

    @Override
    public Optional<User> delete(Long id) {
        return Optional.ofNullable(this.repository.delete(id));
    }


}
