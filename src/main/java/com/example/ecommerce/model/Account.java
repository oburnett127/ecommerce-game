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
@Table(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Basic(optional = false)
        private int id;
        @Basic(optional = false)
        private String email;
        @Basic(optional = false)
        @Column(name = "user_name")
        private String userName;
        @Basic(optional = false)
        private String password;
        @Basic(optional = false)
        @Column(name = "is_admin")
        private boolean isAdmin;
}