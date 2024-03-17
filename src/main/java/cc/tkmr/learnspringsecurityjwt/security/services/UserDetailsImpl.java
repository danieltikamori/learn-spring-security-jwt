package cc.tkmr.learnspringsecurityjwt.security.services;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cc.tkmr.learnspringsecurityjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

// This class represents the implementation of UserDetails interface from Spring Security
public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id; // The unique identifier of the user
    private String username; // The username of the user
    private String email; // The email address of the user
    @JsonIgnore
    private String password; // The password of the user (annotated with @JsonIgnore to exclude it from JSON serialization)
    private Collection<? extends GrantedAuthority> authorities; // The authorities (roles) of the user

    // Constructor to initialize the UserDetailsImpl object
    public UserDetailsImpl(Long id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    // Static method to build a UserDetailsImpl object from a User object
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    // Implementation of UserDetails interface method
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Getter for the id field
    public Long getId() {
        return id;
    }

    // Getter for the email field
    public String getEmail() {
        return email;
    }

    // Implementation of UserDetails interface method
    @Override
    public String getPassword() {
        return password;
    }

    // Implementation of UserDetails interface method
    @Override
    public String getUsername() {
        return username;
    }

    // Implementation of UserDetails interface method
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Implementation of UserDetails interface method
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Implementation of UserDetails interface method
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Implementation of UserDetails interface method
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Implementation of Object's equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}