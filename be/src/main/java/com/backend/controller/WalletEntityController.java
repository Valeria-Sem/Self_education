package com.backend.controller;

import com.backend.entity.WalletEntity;
import com.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
public class WalletEntityController {
    @Autowired
    private WalletEntityService walletEntityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<WalletEntity> getAllWallets(){
        return walletEntityService.getAllWallets();
    }

    @RequestMapping(method = RequestMethod.POST)
    public WalletEntity saveWallet(@RequestBody WalletEntity walletEntity){
        return walletEntityService.saveWallet(walletEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<WalletEntity> getWalletById(@PathVariable(name ="id") Integer id) {
        Optional<WalletEntity> wallet = walletEntityService.getWalletById(id);
        return wallet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable(name = "id") Integer id) {
        walletEntityService.deleteWallet(id);
    }

}
