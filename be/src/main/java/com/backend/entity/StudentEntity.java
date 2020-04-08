package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "self_edu", catalog = "")
public class StudentEntity {
    private int idStudent;
    private String name;
    private String surname;
    private String patronymic;
    private int groupId;
    private UserEntity userByUserId;
    private WalletEntity walletByWalletId;

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }


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
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return idStudent == that.idStudent &&
                groupId == that.groupId &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, surname, patronymic, groupId);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id_wallet", nullable = false)
    public WalletEntity getWalletByWalletId() {
        return walletByWalletId;
    }

    public void setWalletByWalletId(WalletEntity walletByWalletId) {
        this.walletByWalletId = walletByWalletId;
    }
}
