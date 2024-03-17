// Import necessary packages
package cc.tkmr.learnspringsecurityjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define the TestController class
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    // Define a GET endpoint for all access
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    // Define a GET endpoint for user access
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    // Define a GET endpoint for moderator access
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    // Define a GET endpoint for admin access
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}

/*
 * This code block defines a TestController class that handles HTTP requests for different endpoints. Here's a breakdown of what each part does:
 *
 * The @CrossOrigin annotation allows cross-origin requests from any origin and sets the maximum age of the preflight response cache to 3600 seconds (1 hour).
 * The @RestController annotation indicates that this class is a controller that handles HTTP requests and returns data in the response body.
 * The @RequestMapping("/api/test") annotation specifies the base URL path for all endpoints defined in this class.
 * The @GetMapping("/all") annotation defines a GET endpoint for the /api/test/all URL path. This endpoint returns the string "Public Content".
 * The @GetMapping("/user") annotation defines a GET endpoint for the /api/test/user URL path. This endpoint requires the user to have a role of either "USER", "MODERATOR", or "ADMIN" to access it.
 * The @GetMapping("/mod") annotation defines a GET endpoint for the /api/test/mod URL path. This endpoint requires the user to have a role of "MODERATOR" to access it.
 * The @GetMapping("/admin") annotation defines a GET endpoint for the /api/test/admin URL path. This endpoint requires the user to have a role of "ADMIN" to access it.
 */