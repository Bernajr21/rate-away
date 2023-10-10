package com.msvc.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "information")
    private String information;

    @Transient
    private List<Calification> califications = new ArrayList<>();

}
