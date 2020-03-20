package com.backend.entity;

import com.backend.entity.enums.WalletStatus;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "self_education", catalog = "")
public class WalletEntity {
    private int idWallet;
    private int balance;
    private WalletStatus status;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public WalletStatus getStatus() {
        return status;
    }

    public void setStatus(WalletStatus status) {
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
}
