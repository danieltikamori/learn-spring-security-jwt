/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.learnspringsecurityjwt.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;

public class SignupRequest {
    // Declare a private String variable named "username"
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    // Declare a private String variable named "email"
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    // Declare a private Set of String variables named "role"
    private Set<String> role;

    // Declare a private String variable named "password"
    @NotBlank
    @Size(min = 6, max = 120)
    private String password;

    // Getter method for the "username" variable
    public String getUsername() {
        return username;
    }

    // Setter method for the "username" variable
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for the "email" variable
    public String getEmail() {
        return email;
    }

    // Setter method for the "email" variable
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for the "password" variable
    public String getPassword() {
        return password;
    }

    // Setter method for the "password" variable
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method for the "role" variable
    public Set<String> getRole() {
        return this.role;
    }

    // Setter method for the "role" variable
    public void setRole(Set<String> role) {
        this.role = role;
    }
}