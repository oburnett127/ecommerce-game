package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

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
        @Basic(optional = false)
        private int id;
        @Basic(optional = false)
        private String name;
        @Basic(optional = false)
        @Column(name = "market_price")
        private int marketPrice;
        @ManyToOne(optional = true)
        private Collection collection;
        @ManyToOne(optional = true)
        private Purchase purchase;
}