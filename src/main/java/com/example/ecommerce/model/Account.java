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
@Table(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        private String email;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        private String password;
        @Column(name = "is_admin")
        private boolean isAdmin;
}