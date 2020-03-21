package com.backend.controller;

import com.backend.entity.UserEntity;
import com.backend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserEntityController {

    @Autowired
    private UserEntityService userEntityService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUsersByLogin(@PathVariable(name = "login") String login) {
        UserEntity userEntity = userEntityService.findByLogin(login);
        return ResponseEntity.ok(userEntity);
    }
    @RequestMapping(value = "/login/{login}/{pass}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUsersByLoginP(@PathVariable(name = "login") String login,
                                                       @PathVariable(name = "pass") String pass) {
        UserEntity userEntity = userEntityService.getUserIdByLoginAndPassword(login, pass);
        return ResponseEntity.ok(userEntity);
    }

    @RequestMapping(value = "/delete/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser) {
        userEntityService.delete(idUser);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserEntity> getAllUsers(){
        return userEntityService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userEntityService.save(userEntity);
    }
}
