package com.backend.controller;

import com.backend.entity.WalletEntity;
import com.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet/")
public class WalletReplenishmentController {
    @Autowired
    private WalletEntityService walletEntityService;

    @RequestMapping(value = "replenishment", method = RequestMethod.POST)
    public WalletEntity balanceReplenishment(@RequestBody WalletEntity walletEntity){
        return walletEntityService.balanceReplenishment(walletEntity);
    }
}
