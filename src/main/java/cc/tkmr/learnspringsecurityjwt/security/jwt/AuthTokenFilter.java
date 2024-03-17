/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.learnspringsecurityjwt.security.jwt;

import java.io.IOException;

// Import necessary classes for servlets
import cc.tkmr.learnspringsecurityjwt.security.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Import logging classes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Import Spring Security classes for authentication
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

// Custom filter for handling JWT Authentication
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils; // Autowired utility class for JWT operations

    @Autowired
    private UserDetailsServiceImpl userDetailsService; // Autowired service for user details

    @Autowired
    private AuthenticationManager authenticationManager; // Autowired Authentication Manager for authentication checks

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class); // Logger for logging messages
    private final AntPathRequestMatcher skipMatcher = new AntPathRequestMatcher("/api/auth/**", "GET"); // Matcher to skip JWT authentication for certain paths

    // Method to filter each incoming request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Extract JWT token from request
            String jwt = parseJwt(request);
            // Validate JWT token
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                // Extract username from JWT token
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                // Load user details by username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Create authentication token with user details
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,
                                userDetails.getAuthorities());

                // Set additional authentication details
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Authenticate user using AuthenticationManager for additional checks
                authenticationManager.authenticate(authentication);

                // Set the authentication in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            // Log error if authentication fails
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }

    // Method to extract JWT token from request
    private String parseJwt(HttpServletRequest request) {
        String jwt = jwtUtils.getJwtFromCookies(request);
        return jwt;
    }

    // Method to decide whether to skip filtering based on request path
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return skipMatcher.matches(request);
    }

}