package com.example.ecommerce.model.request;

import com.example.ecommerce.model.Product;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PurchaseCreateRequest {
    private int accountId;
    private List<Product> products;
    private String billUserName;
}
