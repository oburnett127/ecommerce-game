package com.example.ecommerce.service;

import com.example.ecommerce.model.Purchase;
import com.example.ecommerce.repository.AccountRepository;
import com.example.ecommerce.repository.PurchaseRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final AccountRepository accountRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, AccountRepository accountRepository) {
        this.purchaseRepository = purchaseRepository;
        this.accountRepository = accountRepository;
    }

    public List<Purchase> listAll() {
        return this.purchaseRepository.findAll();
    }

    @SneakyThrows
    public Purchase getPurchase(final int purchaseId) {
        return this.purchaseRepository.getById(purchaseId);
    }

    public void createPurchase(Purchase purchase) {

        //TODO: Make sure the user has enough points

        this.purchaseRepository.save(purchase);
    }
}