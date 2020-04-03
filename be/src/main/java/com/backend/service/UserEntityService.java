package com.backend.service;


import com.backend.entity.UserEntity;

public interface UserEntityService {
    Iterable<UserEntity> getAllUsers();
    UserEntity findByLogin(String login);
    UserEntity save(UserEntity userEntity);
    UserEntity findByIdUser(Integer idUser);
    void delete(int idUser);

}
