/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

// Importing the necessary packages
package cc.tkmr.learnspringsecurityjwt.repository;

// Importing the Role model class from the learn-spring-security-jwt project
import cc.tkmr.learnspringsecurityjwt.models.ERole;
import cc.tkmr.learnspringsecurityjwt.models.Role;

// Importing the JpaRepository interface from the Spring Data JPA library
import org.springframework.data.jpa.repository.JpaRepository;

// Importing the @Repository annotation from the Spring framework
import org.springframework.stereotype.Repository;

// Importing the Optional class from the Java utility library
import java.util.Optional;

// Defining the RoleRepository interface as a JPA repository for the Role model class
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Defining a custom method to find a Role by its name
    Optional<Role> findByName(ERole name);
}