/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.learnspringsecurityjwt.payload.request;

// This class represents the login request payload
// It contains the username and password fields which are annotated with @NotBlank to ensure they are not empty

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    // The username for the login request
    @NotBlank
    private String username;

    // The password for the login request
    @NotBlank
    private String password;

    // Getter method for retrieving the username
    public String getUsername() {
        return username;
    }

    // Setter method for setting the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for retrieving the password
    public String getPassword() {
        return password;
    }

    // Setter method for setting the password
    public void setPassword(String password) {
        this.password = password;
    }
}