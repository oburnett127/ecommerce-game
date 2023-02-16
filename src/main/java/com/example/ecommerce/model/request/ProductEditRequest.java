package com.example.ecommerce.model.request;

import lombok.Data;

@Data
public class ProductEditRequest {
    private int accountId;
    private int productId;
    private String name;
    private int marketPrice;
}
