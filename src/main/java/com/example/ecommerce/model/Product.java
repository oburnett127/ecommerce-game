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
        private String description;
        @Column(name = "unit_price")
        private BigDecimal unitPrice;
        @Column(name = "units_in_stock")
        private int unitsInStock;
        //@ManyToOne
        //@JoinColumn(name="account_id", nullable=true)
        //private Cart cart;
        //@ManyToOne
        //@JoinColumn(name = "account_id")
        //private Purchase purchase;
}