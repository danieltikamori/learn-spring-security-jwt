// Import necessary classes and packages
package cc.tkmr.learnspringsecurityjwt.security.services;

import cc.tkmr.learnspringsecurityjwt.models.User;
import cc.tkmr.learnspringsecurityjwt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Define a service class UserDetailsServiceImpl that implements UserDetailsService interface
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Autowire UserRepository for database interaction
    @Autowired
    UserRepository userRepository;

    // Method to load user details by username
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username in the UserRepository or throw an exception if not found
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        // Build UserDetailsImpl object based on the retrieved user
        return UserDetailsImpl.build(user);
    }
}