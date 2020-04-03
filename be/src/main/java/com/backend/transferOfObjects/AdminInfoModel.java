package com.backend.transferOfObjects;

import com.backend.entity.enums.UserRole;
import com.backend.entity.enums.WalletStatus;

public class AdminInfoModel extends AbstractRegistrationModel  {

    public AdminInfoModel() {
    }

    public AdminInfoModel(int idUser, String login,
                          String password, UserRole role) {
        super(idUser, login, password, role);

    }
}
