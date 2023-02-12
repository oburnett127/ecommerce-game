package com.example.ecommerce.model;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ProductEditRequest {
    private int id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int unitsInStock;
}
