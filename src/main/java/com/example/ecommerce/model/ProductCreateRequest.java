package com.example.ecommerce.model;

import lombok.Data;
import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ProductCreateRequest {
    private String name;
    private String description;
    private int marketPrice;
}
