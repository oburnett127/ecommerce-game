package com.example.ecommerce.service;

import com.example.ecommerce.exception.InvalidEditException;
import com.example.ecommerce.exception.InvalidPermissionException;
import com.example.ecommerce.model.Collection;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CollectionRepository;
import com.example.ecommerce.repository.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class CollectionService {
    private final CollectionRepository collectionRepository;
    private final ProductRepository productRepository;

    public CollectionService(CollectionRepository collectionRepository, ProductRepository productRepository) {
        this.collectionRepository = collectionRepository;
        this.productRepository = productRepository;
    }

    @SneakyThrows
    public Collection getCollection(final int accountId) {
        return this.collectionRepository.getById(accountId);
    }

    @SneakyThrows
    public Collection addToCollection(int accountId, int productId) {
        final var collection = collectionRepository.getById(accountId);
        final var product = this.productRepository.getById(productId);

        List<Product> productList = collection.getProducts();
        productList.add(product);
        collection.setProducts(productList);

        this.collectionRepository.save(collection);

        //Todo: remove product from marketplace

        return collection;
    }

    @SneakyThrows
    public Collection removeFromCollection(int accountId, int productId) {
        final var collection = collectionRepository.getById(accountId);
        final var product = this.productRepository.getById(productId);

        List<Product> productList = collection.getProducts();
        productList.remove(product);
        collection.setProducts(productList);

        this.collectionRepository.save(collection);

        //Todo: Decide what happens to the product after it is removed
        //from the collection, should it be added back to marketplace?

        return collection;
    }
}