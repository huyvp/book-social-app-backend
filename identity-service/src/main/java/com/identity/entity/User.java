package com.identity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @Column(name = "username", length = 50, nullable = false)
    String username;
    @Column(name = "password", length = 200, nullable = false)
    String password;
    @Column(name = "email", length = 200, nullable = false)
    String email;
    @Column(name = "address", length = 200)
    String address;
    @Column(name = "phone_number", length = 10, nullable = false)
    String phoneNumber;
    @ManyToMany
    Set<Role> roles;
}
