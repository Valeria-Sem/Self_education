package com.backend.controller;

import com.backend.service.RegistrationService;
import com.backend.transferOfObjects.AbstractRegistrationModel;
import com.backend.transferOfObjects.StudentRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/api/login/{login}/password/{password}/login", method = RequestMethod.GET)
    public ResponseEntity<AbstractRegistrationModel> getUserInfo(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password) {
        AbstractRegistrationModel information =  registrationService.getUserInfo(login, password);
        return ResponseEntity.ok(information);
    }

    @RequestMapping(value = "/api/registration/student/{idStudent}", method = RequestMethod.GET)
    public ResponseEntity<AbstractRegistrationModel> getUserInfoByIdStudent(
            @PathVariable(name = "idStudent") int idStudent) {
        AbstractRegistrationModel studInfo =  registrationService.getUserInfoByIdStudent(idStudent);
        return ResponseEntity.ok(studInfo);
    }

    @RequestMapping(value = "/api/registration/student",method = RequestMethod.POST)
    public AbstractRegistrationModel registerStudent(@RequestBody StudentRegistrationModel studentRegistrationModel){
        return registrationService.registerUser(studentRegistrationModel);
    }

    @RequestMapping(value = "/api/registration/user/delete/{idUser}/{idWallet}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser,
                           @PathVariable(name = "idWallet") Integer idWallet) {
        registrationService.deleteUserProfile(idUser, idWallet);
    }
}
