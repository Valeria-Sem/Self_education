package com.backend.service.impl;

import com.backend.entity.StudentEntity;
import com.backend.entity.UserEntity;
import com.backend.entity.WalletEntity;
import com.backend.entity.enums.UserRole;
import com.backend.service.ProductEntityService;
import com.backend.service.RegistrationService;
import com.backend.service.StudentEntityService;
import com.backend.service.UserEntityService;
import com.backend.transferOfObjects.AbstractRegistrationModel;
import com.backend.transferOfObjects.AdminInfoModel;
import com.backend.transferOfObjects.StudentRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private WalletEntityServiceImpl walletEntityService;
    private UserEntityService userEntityService;
    private StudentEntityService studentEntityService;
    private ProductEntityService productEntityService;

    @Autowired
    public RegistrationServiceImpl(WalletEntityServiceImpl walletEntityService,
                                   UserEntityService userEntityService,
                                   StudentEntityService studentEntityService,
                                   ProductEntityService productEntityService) {
        this.walletEntityService = walletEntityService;
        this.userEntityService = userEntityService;
        this.studentEntityService = studentEntityService;
        this.productEntityService = productEntityService;
    }

    @Override
    public AbstractRegistrationModel registerUser(AbstractRegistrationModel abstractRegistrationModel) {
        UserEntity user = saveNewUser(abstractRegistrationModel);
        WalletEntity wallet = saveNewWallet((StudentRegistrationModel) abstractRegistrationModel);
//        GroupEntity group = saveStudGroup(abstractRegistrationModel);

        saveNewStudent((StudentRegistrationModel) abstractRegistrationModel, user, wallet );

        abstractRegistrationModel.setIdUser(user.getIdUser());
//        abstractRegistrationModel.setIdWallet(wallet.getIdWallet());
        return abstractRegistrationModel;
    }

    private UserEntity saveNewUser(AbstractRegistrationModel info){
        UserEntity usersEntity = new UserEntity();
        usersEntity.setLogin(info.getLogin());
        usersEntity.setPassword(info.getPassword());
        usersEntity.setRole(info.getRole());
        userEntityService.save(usersEntity);
        return usersEntity;
    }

    private WalletEntity saveNewWallet(StudentRegistrationModel walletInfo){
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(walletInfo.getBalance());
        walletEntity.setStatus(walletInfo.getWalletStatus());
        walletEntityService.saveWallet(walletEntity);
        return walletEntity;
    }

    private void saveNewStudent(StudentRegistrationModel info, UserEntity user, WalletEntity wallet){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(info.getName());
        studentEntity.setSurname(info.getSurname());
        studentEntity.setPatronymic(info.getPatronymic());
        studentEntity.setGroupId(info.getIdGroup());
        studentEntity.setUserByUserId(user);
        studentEntity.setWalletByWalletId(wallet);
        studentEntityService.saveStudent(studentEntity);
    }

    @Override
    public AbstractRegistrationModel getUserInfo(String log, String pas) {
        UserEntity userEntity = userEntityService.getUserIdByLoginAndPassword(log, pas);
        if(userEntity.getRole().equals(UserRole.ADMIN)) {
            return new AdminInfoModel(userEntity.getIdUser(),
                    userEntity.getLogin(),
                    userEntity.getPassword(),
                    userEntity.getRole());
        } else {
            StudentEntity studentEntity = studentEntityService.getStudentEntityByUserByIdUser(userEntity);
            WalletEntity walletEntity = studentEntity.getWalletByWalletId();
            return new StudentRegistrationModel(userEntity.getIdUser(),
                    userEntity.getLogin(),
                    userEntity.getPassword(),
                    userEntity.getRole(),
                    studentEntity.getIdStudent(),
                    studentEntity.getName(),
                    studentEntity.getSurname(),
                    studentEntity.getPatronymic(),
                    studentEntity.getGroupId(),
                    walletEntity.getIdWallet(),
                    walletEntity.getBalance(),
                    walletEntity.getStatus());
        }
    }

    @Override
    public void deleteUserProfile(int idUser, int idWallet) {
        userEntityService.delete(idUser);
        walletEntityService.deleteWallet(idWallet);
    }
}
