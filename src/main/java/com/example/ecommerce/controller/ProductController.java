package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.model.request.ProductCreateRequest;
import com.example.ecommerce.model.request.ProductDeleteRequest;
import com.example.ecommerce.model.request.ProductEditRequest;
import com.example.ecommerce.model.request.ProductGetRequest;
import com.example.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Product> getProduct(@Validated @RequestBody ProductGetRequest productRequest) {
        final var product = service.getProduct(productRequest.getId());
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody ProductCreateRequest createProductRequest) throws IOException {
        final var accountId = createProductRequest.getAccountId();
        final var product = Product.builder()
                .name(createProductRequest.getName())
                .marketPrice(createProductRequest.getMarketPrice())
                .build();
        service.createProduct(accountId, product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/edit")
    public ResponseEntity<Product> editProduct(@Validated @RequestBody ProductEditRequest editRequest) throws IOException {
        final var accountId = editRequest.getAccountId();
        final var productId = editRequest.getProductId();
        final var name = editRequest.getName();
        final var marketPrice = editRequest.getMarketPrice();
        final var result = service.editProduct(accountId, productId, name, marketPrice);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Product> deleteProduct(@Validated @RequestBody ProductDeleteRequest deleteRequest) throws IOException {
        final var accountId = deleteRequest.getAccountId();
        final var productId = deleteRequest.getProductId();
        service.deleteProduct(accountId, productId);
        return ResponseEntity.ok().body(null);
    }
}