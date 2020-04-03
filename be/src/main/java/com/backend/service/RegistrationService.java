package com.backend.service;

import com.backend.transferOfObjects.AbstractRegistrationModel;

public interface RegistrationService {
    AbstractRegistrationModel registerUser(AbstractRegistrationModel abstractRegistrationModel);
    AbstractRegistrationModel getUserInfo(String log, String pas);
    void deleteUserProfile(int idUser, int idWallet);
}
