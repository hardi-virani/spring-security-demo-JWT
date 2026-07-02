package com.star.spring_security_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") //Map the original "users" table, we created manually in pgAdmin.

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String username;
    private String password;


}
