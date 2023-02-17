package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.model.request.PurchaseCreateRequest;
import com.example.ecommerce.model.request.PurchaseDeleteRequest;
import com.example.ecommerce.model.request.PurchaseEditRequest;
import com.example.ecommerce.model.request.PurchaseGetRequest;
import com.example.ecommerce.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

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
        final var purchase = service.getPurchase(purchaseRequest.getId());
        return ResponseEntity.ok().body(purchase);
    }

    @PostMapping("/create")
    public ResponseEntity<Purchase> createPurchase(@Validated @RequestBody PurchaseCreateRequest createRequest) throws IOException {
        final var accountId = createRequest.getAccountId();
        final var purchase = Purchase.builder()
                .name(createRequest.getName())
                .marketPrice(createRequest.getMarketPrice())
                .build();
        service.createPurchase(accountId, purchase);
        return ResponseEntity.ok(purchase);
    }

    @PostMapping("/edit")
    public ResponseEntity<Purchase> editPurchase(@Validated @RequestBody PurchaseEditRequest editRequest) throws IOException {
        final var accountId = editRequest.getAccountId();
        final var purchaseId = editRequest.getPurchaseId();
        final var name = editRequest.getName();
        final var marketPrice = editRequest.getMarketPrice();
        final var result = service.editPurchase(accountId, purchaseId, name, marketPrice);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Purchase> deletePurchase(@Validated @RequestBody PurchaseDeleteRequest deleteRequest) throws IOException {
        final var accountId = deleteRequest.getAccountId();
        final var purchaseId = deleteRequest.getPurchaseId();
        service.deletePurchase(accountId, purchaseId);
        return ResponseEntity.ok().body(null);
    }
}