package cc.tkmr.learnspringsecurityjwt.security.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Importing necessary servlet classes for handling HTTP requests and responses
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Importing logging interfaces
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Importing classes for handling HTTP status codes and media types
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

// Importing ObjectMapper for JSON serialization and deserialization
import com.fasterxml.jackson.databind.ObjectMapper;

// Component annotation to indicate that this class is a Spring bean
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    // Initializing logger for this class
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    // Method called when a user is not authenticated
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {

        // Logging unauthorized error
        logger.error("Unauthorized error: {}", getSafeErrorMessage(authException));

        // Setting response content type to JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // Setting response status to 401 Unauthorized
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // Use HttpStatus for clearer code

        // Creating a map to hold error information
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Unauthorized");

        // Setting a generic error message
        body.put("message", "You are not authorized to access this resource"); // Generic message for production
        body.put("path", request.getServletPath());

        // Creating ObjectMapper instance for JSON serialization
        final ObjectMapper mapper = new ObjectMapper();

        // Writing the error response to the output stream
        mapper.writeValue(response.getOutputStream(), body);
    }

    // Method to safely get the authentication error message
    private String getSafeErrorMessage(AuthenticationException authException) {
        return (authException == null) ? "Unauthorized" : authException.getMessage();
    }
}