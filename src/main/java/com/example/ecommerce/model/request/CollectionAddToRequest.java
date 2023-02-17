package com.example.ecommerce.model.request;

import lombok.Data;

@Data
public class CollectionAddToRequest {
    private int accountId;
    private int productId;
}
