package cc.tkmr.learnspringsecurityjwt.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * User Entity that maps to the "users" table in the database
 */
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 240)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor for creating a new user
     * @param username the username
     * @param email the email address
     * @param password the password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getters and setters

    /**
     * Get the user's ID
     * @return the user's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the user's ID
     * @param id the user's ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's email address
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the roles associated with the user
     * @return the user's roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Set the roles for the user
     * @param roles the user's roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}