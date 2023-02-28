package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Purchase {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name="purchase_id")
        private int purchaseId;
        private int accountId;
        @Column(name = "purchase_date")
        private String purchaseDate;
        @OneToMany(mappedBy="purchase")
        private Set<Product> product;
        @Column(name = "bill_user_name")
        private String billUserName;
}