package com.forum.system.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "USERNAME")
    String username;

    @Column(name = "PASSWORD")
    String password;
}
