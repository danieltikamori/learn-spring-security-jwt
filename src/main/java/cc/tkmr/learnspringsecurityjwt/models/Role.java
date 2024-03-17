package cc.tkmr.learnspringsecurityjwt.models;

import jakarta.persistence.*;

// This class represents a Role entity in the database
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Unique identifier for the role

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name; // Name of the role

    public Role() {
        // Default constructor
    }

    public Role(ERole name) {
        this.name = name; // Constructor setting the name of the role
    }

    // getters and setters

    // Get the id of the role
    public Integer getId() {
        return id;
    }

    // Set the id of the role
    public void setId(Integer id) {
        this.id = id;
    }

    // Get the name of the role
    public ERole getName() {
        return name;
    }

    // Set the name of the role
    public void setName(ERole name) {
        this.name = name;
    }
}