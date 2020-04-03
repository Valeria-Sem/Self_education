package com.backend.service.impl;

import com.backend.entity.WalletEntity;
import com.backend.repository.WalletEntityRepository;
import com.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletEntityServiceImpl implements WalletEntityService {
    private final WalletEntityRepository walletEntityRepository;

    @Autowired
    public WalletEntityServiceImpl(WalletEntityRepository walletEntityRepository){
        this.walletEntityRepository = walletEntityRepository;
    }

    @Override
    public WalletEntity saveWallet(WalletEntity wallet) {
        return walletEntityRepository.save(wallet);
    }

    @Override
    public Optional<WalletEntity> getWalletById(Integer idWallet) {
        return walletEntityRepository.findById(idWallet);
    }

    @Override
    public WalletEntity balanceReplenishment(WalletEntity wallet) {
        return walletEntityRepository.save(wallet);
    }

    @Override
    public WalletEntity payment(WalletEntity wallet) {
        return walletEntityRepository.save(wallet);
    }

    @Override
    public Iterable<WalletEntity> getAllWallets() {
        return walletEntityRepository.findAll();
    }

    @Override
    public void deleteWallet(Integer idWallet) {
        walletEntityRepository.deleteById(idWallet);
    }
}
