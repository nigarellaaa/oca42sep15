package com.example.oca42.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses; //open in view

    //OneToOne -> id ler her iki terefde saxlanila biler
    //OneToMany -> id many terefde saxlanilir
    //ManyToOne -> id many terefde saxlanilir
    //ManyToMany -> id ler 3 cu table da saxlanilir

}
