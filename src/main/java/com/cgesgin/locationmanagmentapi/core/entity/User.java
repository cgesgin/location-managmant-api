package com.cgesgin.locationmanagmentapi.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;

}
