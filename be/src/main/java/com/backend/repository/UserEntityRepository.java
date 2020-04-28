package com.backend.repository;

import com.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
    UserEntity findByIdUser(Integer IdUser);
    UserEntity getIdUserByLoginAndPassword(String login, String password);

}
