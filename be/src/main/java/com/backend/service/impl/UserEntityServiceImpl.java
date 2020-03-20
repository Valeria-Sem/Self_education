package com.backend.service.impl;

import com.backend.entity.UserEntity;
import com.backend.repository.UserEntityRepository;
import com.backend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public Iterable<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserIdByLoginAndPassword(String login, String password) {
        UserEntity user = userEntityRepository.getUserIdByLoginAndPassword(login, password);
        if (user == null) {
            throw new Error("Invalid login or password");
//            try {
//                UsersEntity user = usersEntityRepository.getUserIdByLoginAndPassword(login, password);
//                throw new Error();
//            } catch (NotFoundException e){
//                throw new RuntimeException(e.getMessage(), e);
//                throw new Error();
//            }
        } else {
            return userEntityRepository.getUserIdByLoginAndPassword(login, password);
        }
    }

    @Override
    public void delete(int idUser) {
        userEntityRepository.deleteById(idUser);
    }
}
