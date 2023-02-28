package com.example.ecommerce.service;

import com.example.ecommerce.exception.InvalidEditException;
import com.example.ecommerce.exception.InvalidPermissionException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.AccountRepository;
import com.example.ecommerce.repository.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    public ProductService(ProductRepository productRepository, AccountRepository accountRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
    }

    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    @SneakyThrows
    public Product getProduct(final int id) {
        return this.productRepository.getById(id);
    }

    public void createProduct(int accountId, Product product) {
        String message = "";
        final var account = accountRepository.getById(accountId);
        if(account.isAdmin() == false) throw new InvalidPermissionException();
        this.productRepository.save(product);
    }

    @SneakyThrows
    public Product editProduct(int accountId, int productId, String name, int marketPrice) {
        String message = "";
        final var account = accountRepository.getById(accountId);
        if(account.isAdmin() == false) throw new InvalidPermissionException();

        if(name.isBlank() || name == null || !name.matches("^[a-zA-Z0-9]*$")) {
            message = "Product name cannot be blank and must be alphanumeric.";
            throw new InvalidEditException(message);
        }

        if(marketPrice < 0) {
            message = "Price must be a non-negative, integer.";
            throw new InvalidEditException(message);
        }

        final var product = this.productRepository.getById(productId);
        product.setName(name);
        product.setMarketPrice(marketPrice);
        this.productRepository.save(product);
        return product;
    }

    public void deleteProduct(int accountId, int productId) {
        String message = "";
        final var account = accountRepository.getById(accountId);
        if(account.isAdmin() == false) throw new InvalidPermissionException();
        this.productRepository.deleteById(productId);
    }
}