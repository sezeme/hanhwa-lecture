package com.sezeme.springsecurity.command.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="users")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role = UserRole.UESR;

    public void setEncodedPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
