package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
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
        final var product = Product.builder()
                .name(createProductRequest.getName())
                .description(createProductRequest.getDescription())
                .unitPrice(createProductRequest.getUnitPrice())
                .unitsInStock(createProductRequest.getUnitsInStock())
                .build();
        service.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/edit")
    public ResponseEntity<Product> editProduct(@Validated @RequestBody ProductEditRequest editRequest) throws IOException {
        final var id = editRequest.getId();
        final var name = editRequest.getName();
        final var description = editRequest.getDescription();
        final var unitPrice = editRequest.getUnitPrice();
        final var unitsInStock = editRequest.getUnitsInStock();
        final var result = service.editProduct(id, name, description, unitPrice, unitsInStock);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Product> deleteProduct(@Validated @RequestBody ProductDeleteRequest deleteRequest) throws IOException {
        final var id = deleteRequest.getId();
        service.deleteProduct(id);
        return ResponseEntity.ok().body(null);
    }
}