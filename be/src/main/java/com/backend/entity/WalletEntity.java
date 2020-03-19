package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "self_education", catalog = "")
public class WalletEntity {
    private int idWallet;
    private int balance;
    private Object status;
    private Collection<StudentEntity> studentsByIdWallet;

    @Id
    @Column(name = "id_wallet")
    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Basic
    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "status")
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return idWallet == that.idWallet &&
                balance == that.balance &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWallet, balance, status);
    }

    @OneToMany(mappedBy = "walletByIdWallet")
    public Collection<StudentEntity> getStudentsByIdWallet() {
        return studentsByIdWallet;
    }

    public void setStudentsByIdWallet(Collection<StudentEntity> studentsByIdWallet) {
        this.studentsByIdWallet = studentsByIdWallet;
    }
}
