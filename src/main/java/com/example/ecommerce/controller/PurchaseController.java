package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.model.request.PurchaseCreateRequest;
import com.example.ecommerce.model.request.PurchaseGetRequest;
import com.example.ecommerce.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/purchase")
@Slf4j
public class PurchaseController {
    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Purchase>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Purchase> getPurchase(@Validated @RequestBody PurchaseGetRequest purchaseRequest) {
        final var purchase = service.getPurchase(purchaseRequest.getPurchaseId());
        return ResponseEntity.ok().body(purchase);
    }

    @PostMapping("/create")
    public ResponseEntity<Purchase> createPurchase(@Validated @RequestBody PurchaseCreateRequest createRequest) throws IOException {
        final var accountId = createRequest.getAccountId();
        final var purchaseDate = new Date().toString();
        final var products = createRequest.getProducts();
        final var billUserName = createRequest.getBillUserName();
        final var purchase = Purchase.builder()
                .accountId(accountId)
                .purchaseDate(purchaseDate)
                .products(products)
                .billUserName(billUserName)
                .build();
        service.createPurchase(purchase);
        return ResponseEntity.ok(purchase);
    }
}