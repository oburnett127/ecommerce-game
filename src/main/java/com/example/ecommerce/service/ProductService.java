package com.example.ecommerce.service;

import com.example.ecommerce.exception.InvalidEditException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    @SneakyThrows
    public Product getProduct(final int id) {
        final var product = this.productRepository.getById(id);
        return product;
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    @SneakyThrows
    public Product editProduct(int id, String name, String description, BigDecimal unitPrice, int unitsInStock) {

        //To do: Make sure the user is an admin

        String message = "";

        if(name.isBlank() || name == null || !name.matches("^[a-zA-Z0-9]*$")) {
            message = "Product name cannot be blank and must be alphanumeric.";
            throw new InvalidEditException(message);
        }

        if(description.isBlank() || description == null) {
            message = "Product description cannot be blank and must be alphanumeric.";
            throw new InvalidEditException(message);
        }

        if(unitPrice.compareTo(new BigDecimal(0.0)) < 0) {
            message = "Price must be a non-negative, decimal number.";
            throw new InvalidEditException(message);
        }

        if(unitsInStock < 0) {
            message = "Units in stock must be greater than or equal to zero.";
            throw new InvalidEditException(message);
        }

        final var product = this.productRepository.getById(id);

        product.setName(name);
        product.setDescription(description);
        product.setUnitPrice(unitPrice);
        product.setUnitsInStock(unitsInStock);
        this.productRepository.save(product);
        return product;
    }

    public void deleteProduct(int id) { this.productRepository.deleteById(id); }
}