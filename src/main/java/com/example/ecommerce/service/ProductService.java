package com.example.ecommerce.service;

import com.example.ecommerce.exception.InvalidEditException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
        return this.productRepository.getById(id);
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    @SneakyThrows
    public Product editProduct(int id, String name, int marketPrice) {
        //=============
        //To do: Make sure the user is an admin
        //=============
        String message = "";

        if(name.isBlank() || name == null || !name.matches("^[a-zA-Z0-9]*$")) {
            message = "Product name cannot be blank and must be alphanumeric.";
            throw new InvalidEditException(message);
        }

        if(marketPrice < 0) {
            message = "Price must be a non-negative, integer.";
            throw new InvalidEditException(message);
        }

        final var product = this.productRepository.getById(id);

        product.setName(name);
        product.setMarketPrice(marketPrice);
        this.productRepository.save(product);
        return product;
    }

    public void deleteProduct(int id) { this.productRepository.deleteById(id); }
}