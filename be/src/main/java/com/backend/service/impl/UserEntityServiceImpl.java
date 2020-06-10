package com.backend.service.impl;

import com.backend.entity.UserEntity;
import com.backend.repository.UserEntityRepository;
import com.backend.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository userEntityRepository
//                                 BCryptPasswordEncoder passwordEncoder
    ) {
        this.userEntityRepository = userEntityRepository;
//        this.passwordEncoder = passwordEncoder;
    }

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
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        userEntity.setRole(UserRole.USER);
//        UserEntity registeredUser = userEntityRepository.save(userEntity);

        log.info("IN save method - user: {} successfully registered", userEntity);

        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity findByIdUser(Integer idUser) {
        UserEntity result = userEntityRepository.findByIdUser(idUser);

        if(result == null){
            log.info("IN findByIdUser method - no user found by id: {}", idUser);
        }
        log.info("IN findByIdUser method - user: {} found by id: {}", result);

        return result;
    }

    @Override
    public UserEntity getUserIdByLoginAndPassword(String login, String password) {
        UserEntity user = userEntityRepository.getIdUserByLoginAndPassword(login, password);
        if (user == null) {
            throw new Error("Invalid login or password");
//            log.info("IN getUserIdByLoginAndPassword method - no user found with login: {}", user);


        } else {
            return userEntityRepository.getIdUserByLoginAndPassword(login, password);
        }
    }

    @Override
    public void delete(int idUser) {
        userEntityRepository.deleteById(idUser);
        log.info("IN delete - user with id: {} successfully deleted", idUser);
    }

    @Override
    public Boolean isLoginExist(String login) {
        return userEntityRepository.existsUserByLogin(login);
    }
}
