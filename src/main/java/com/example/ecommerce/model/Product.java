package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        private String name;
        @Column(name = "market_price")
        private int marketPrice;
        @ManyToOne
        @JoinColumn(name="purchase_id")
        private Purchase purchase;
}