package com.example.pcpicco.model;

import com.example.pcpicco.model.enumeration.Roles;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "project")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer user_id;
    @Column(nullable = false)
    private String email;

    private String name;

    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Roles role;
    @Column(nullable = false)
    private String password;
    public User(){}
    public User(String email,String password, Roles role){
        this.name= name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}