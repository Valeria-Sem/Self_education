package com.backend.repository;

import com.backend.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletEntityRepository extends CrudRepository<WalletEntity, Integer> {
    WalletEntity getBalanceByIdWallet(WalletEntity wallet);
}
