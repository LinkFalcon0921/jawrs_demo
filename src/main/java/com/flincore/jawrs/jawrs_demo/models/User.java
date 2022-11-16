package com.flincore.jawrs.jawrs_demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String firstName;

    @Column
    private String secondName;

    @Column(nullable = false)
    @NotEmpty
    private String paternalLastName;


    @Column
    private String maternalLastName;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> related;

}
