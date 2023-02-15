package com.example.ecommerce.model;

import lombok.Data;

@Data
public class ProductEditRequest {
    private int id;
    private String name;
    private int marketPrice;
}
