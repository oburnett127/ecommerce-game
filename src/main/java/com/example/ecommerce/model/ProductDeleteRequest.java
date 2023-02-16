package com.example.ecommerce.model;

import lombok.Data;

@Data
public class ProductDeleteRequest {
    private int accountId;
    private int productId;
}
