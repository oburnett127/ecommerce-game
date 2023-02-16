package com.example.ecommerce.model;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private int accountId;
    private String name;
    private int marketPrice;
}
