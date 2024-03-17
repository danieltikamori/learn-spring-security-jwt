package cc.tkmr.learnspringsecurityjwt.repository;

import java.util.Optional;

import cc.tkmr.learnspringsecurityjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This interface represents a repository for the User entity, extending the JpaRepository interface for CRUD operations.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by their username, returning an Optional<User> to handle possible absence of the user.
    Optional<User> findByUsername(String username);

    // Method to check if a user with the given username exists, returning a Boolean.
    Boolean existsByUsername(String username);

    // Method to check if a user with the given email exists, returning a Boolean.
    Boolean existsByEmail(String email);
}