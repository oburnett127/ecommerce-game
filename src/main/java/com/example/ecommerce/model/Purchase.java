package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
        @Basic(optional = false)
        @Column(name="purchase_id")
        private int purchaseId;
        @Basic(optional = false)
        private int accountId;
        @Basic(optional = false)
        @Column(name = "purchase_date")
        private String purchaseDate;
        @Basic(optional = false)
        @Column(name = "bill_user_name")
        private String billUserName;
        @OneToMany(mappedBy="purchase")
        private List<Product> products;

}