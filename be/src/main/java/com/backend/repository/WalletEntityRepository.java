package com.backend.repository;

import com.backend.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletEntityRepository extends CrudRepository<WalletEntity, Integer> {
    WalletEntity getBalanceByIdWallet(WalletEntity wallet);
}
