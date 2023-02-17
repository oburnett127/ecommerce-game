package com.example.ecommerce.model.request;

import lombok.Data;

@Data
public class CollectionRemoveFromRequest {
    private int accountId;
    private int productId;
}
