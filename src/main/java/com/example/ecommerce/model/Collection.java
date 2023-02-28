package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "collection")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Collection {
    @Id
    @Basic(optional = false)
    @Column(name="account_id")
    private int accountId;

    @OneToMany(mappedBy="collection")
    private List<Product> products;
}