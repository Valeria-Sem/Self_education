package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "self_education", catalog = "")
public class StudentEntity {
    private int idStudent;
//    private int idUser;
    private String name;
    private String surname;
    private String group;
//    private int idWallet;
    private UserEntity userByIdUser;
    private WalletEntity walletByIdWallet;

    @Id
    @Column(name = "id_student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

//    @Basic
//    @Column(name = "id_user")
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

//    @Basic
//    @Column(name = "id_wallet")
//    public int getIdWallet() {
//        return idWallet;
//    }
//
//    public void setIdWallet(int idWallet) {
//        this.idWallet = idWallet;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return idStudent == that.idStudent &&
//                idUser == that.idUser &&
//                idWallet == that.idWallet &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, surname, group);
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id_wallet", nullable = false)
    public WalletEntity getWalletByIdWallet() {
        return walletByIdWallet;
    }

    public void setWalletByIdWallet(WalletEntity walletByIdWallet) {
        this.walletByIdWallet = walletByIdWallet;
    }

}
