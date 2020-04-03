package com.backend.transferOfObjects;

import com.backend.entity.enums.UserRole;
import com.backend.entity.enums.WalletStatus;

public abstract class AbstractRegistrationModel {
    private int idUser;
    private String login;
    private String password;
    private UserRole role;

//    private int idWallet;
//    private int balance;
//    private WalletStatus walletStatus;


    public AbstractRegistrationModel() {
    }

    public AbstractRegistrationModel(int idUser, String login, String password,UserRole role) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
//        this.idWallet = idWallet;
//        this.balance = balance;
//        this.walletStatus = walletStatus;

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

//    public int getIdWallet() {
//        return idWallet;
//    }
//
//    public void setIdWallet(int idWallet) {
//        this.idWallet = idWallet;
//    }
//
//    public int getBalance() {
//        return balance;
//    }
//
//    public void setBalance(int balance) {
//        this.balance = balance;
//    }
//
//    public WalletStatus getWalletStatus() {
//        return walletStatus;
//    }
//
//    public void setWalletStatus(WalletStatus walletStatus) {
//        this.walletStatus = walletStatus;
//    }
}

