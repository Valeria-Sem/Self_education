package com.backend.service;

import com.backend.entity.WalletEntity;

import java.util.Optional;

public interface WalletEntityService {
    WalletEntity saveWallet(WalletEntity wallet);
    Optional<WalletEntity> getWalletById(Integer idWallet);
    WalletEntity balanceReplenishment(WalletEntity wallet);
    WalletEntity payment (WalletEntity wallet);
    Iterable<WalletEntity> getAllWallets();
    void deleteWallet(Integer idWallet);
}
