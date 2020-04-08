package com.backend.transferOfObjects;

import com.backend.entity.enums.UserRole;
import com.backend.entity.enums.WalletStatus;

public class StudentRegistrationModel extends AbstractRegistrationModel {
    private int idStudent;
    private String name;
    private String surname;



    private String patronymic;

    private int idGroup;

    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    public StudentRegistrationModel() {
    }

    public StudentRegistrationModel(int idUser, String login, String password, UserRole role,
                                    int idStudent, String name, String surname, String patronymic,
                                    int idGroup,
                                    int idWallet, int balance, WalletStatus walletStatus) {
        super(idUser, login, password, role);
        this.idStudent = idStudent;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.idGroup = idGroup;
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public WalletStatus getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(WalletStatus walletStatus) {
        this.walletStatus = walletStatus;
    }

}

