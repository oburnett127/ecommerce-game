package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.model.request.CollectionAddToRequest;
import com.example.ecommerce.model.request.CollectionGetRequest;
import com.example.ecommerce.model.request.CollectionRemoveFromRequest;
import com.example.ecommerce.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/collection")
@Slf4j
public class CollectionController {
    private final CollectionService service;

    public CollectionController(CollectionService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<Collection> getCollection(@Validated @RequestBody CollectionGetRequest collectionRequest) {
        final var collection = service.getCollection(collectionRequest.getAccountId());
        return ResponseEntity.ok().body(collection);
    }

    @PostMapping("/add")
    public ResponseEntity<Collection> addToCollection(@Validated @RequestBody CollectionAddToRequest addRequest) throws IOException {
        final var accountId = addRequest.getAccountId();
        final var productId = addRequest.getProductId();
        final var result = service.addToCollection(accountId, productId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/remove")
    public ResponseEntity<Collection> removeFromCollection(@Validated @RequestBody CollectionRemoveFromRequest removeRequest) throws IOException {
        final var accountId = removeRequest.getAccountId();
        final var productId = removeRequest.getProductId();
        final var result = service.removeFromCollection(accountId, productId);
        return ResponseEntity.ok().body(result);
    }
}