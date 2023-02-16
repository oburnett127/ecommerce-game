package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.model.request.CollectionCreateRequest;
import com.example.ecommerce.model.request.CollectionDeleteRequest;
import com.example.ecommerce.model.request.CollectionEditRequest;
import com.example.ecommerce.model.request.CollectionGetRequest;
import com.example.ecommerce.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

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
        final var collection = service.getCollection(collectionRequest.getId());
        return ResponseEntity.ok().body(collection);
    }

    @PostMapping("/create")
    public ResponseEntity<Collection> createCollection(@Validated @RequestBody CollectionCreateRequest createRequest) throws IOException {
        final var accountId = createRequest.getAccountId();
        final var collection = Collection.builder()
                .name(createRequest.getName())
                .marketPrice(createRequest.getMarketPrice())
                .build();
        service.createCollection(accountId, collection);
        return ResponseEntity.ok(collection);
    }

    @PostMapping("/edit")
    public ResponseEntity<Collection> editCollection(@Validated @RequestBody CollectionEditRequest editRequest) throws IOException {
        final var accountId = editRequest.getAccountId();
        final var collectionId = editRequest.getCollectionId();
        final var name = editRequest.getName();
        final var marketPrice = editRequest.getMarketPrice();
        final var result = service.editCollection(accountId, collectionId, name, marketPrice);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Collection> deleteCollection(@Validated @RequestBody CollectionDeleteRequest deleteRequest) throws IOException {
        final var accountId = deleteRequest.getAccountId();
        final var collectionId = deleteRequest.getCollectionId();
        service.deleteCollection(accountId, collectionId);
        return ResponseEntity.ok().body(null);
    }
}