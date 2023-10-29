package com.example.springsecurityjwt.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "enabled"}))
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 10, nullable = false)
    private String username;
    @Column(length = 512, nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private boolean enabled;
    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    private List<UserRole> roles;
}
