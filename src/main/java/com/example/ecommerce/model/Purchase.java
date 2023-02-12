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
        private int purchaseId;
        private int accountId;
        @Column(name = "purchase_date")
        private String purchaseDate;
        //@OneToMany(mappedBy="purchase")
        //private Set<Product> product;
        @Column(name = "bill_first_name")
        private String billFirstName;
        @Column(name = "bill_last_name")
        private String billLastName;
        @Column(name = "bill_address")
        private String billAddress;
        @Column(name = "credit_card_exp_date")
        private String creditCardExpDate;
        @Column(name = "credit_card_pin")
        private String creditCardPin;
        @Column(name = "credit_card_num")
        private String creditCardNum;
        @Column(name = "credit_card_name")
        private String creditCardName;
}