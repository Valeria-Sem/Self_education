package com.backend.repository;

import com.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
    UserEntity getUserIdByLoginAndPassword(String login, String password);
}
