package com.backend.service;


import com.backend.entity.UserEntity;

public interface UserEntityService {
    Iterable<UserEntity> getAllUsers();
    UserEntity findByLogin(String login);
    UserEntity save(UserEntity userEntity);
    UserEntity findByIdUser(Integer idUser);
    UserEntity getUserIdByLoginAndPassword(String login, String password);
    void delete(int idUser);
    Boolean isLoginExist(String login);

}
