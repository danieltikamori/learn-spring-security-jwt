/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.learnspringsecurityjwt.payload.response;

import java.util.List;

// Class representing the response containing user information
public class UserInfoResponse {
    // User ID
    private Long id;
    // User's username
    private String username;
    // User's email address
    private String email;
    // List of roles assigned to the user
    private List<String> roles;

    // Constructor to create a new UserInfoResponse object with the given parameters
    public UserInfoResponse(Long id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Getter method for retrieving the user's ID
    public Long getId() {
        return id;
    }

    // Setter method for updating the user's ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for retrieving the user's email address
    public String getEmail() {
        return email;
    }

    // Setter method for updating the user's email address
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for retrieving the user's username
    public String getUsername() {
        return username;
    }

    // Setter method for updating the user's username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for retrieving the list of roles assigned to the user
    public List<String> getRoles() {
        return roles;
    }
}