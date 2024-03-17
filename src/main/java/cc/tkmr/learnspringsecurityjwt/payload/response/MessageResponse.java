/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

// Define the package cc.tkmr.learnspringsecurityjwt.payload.response
package cc.tkmr.learnspringsecurityjwt.payload.response;

// Define a public class named MessageResponse that will serve as a response payload
public class MessageResponse {
    // Declare a private member variable to store the message
    private String message;

    // Constructor for the MessageResponse class that takes a message as input
    public MessageResponse(String message) {
        // Set the message member variable to the input message
        this.message = message;
    }

    // Method to get the message stored in the message member variable
    public String getMessage() {
        // Return the message
        return message;
    }

    // Method to set the message member variable to a new message
    public void setMessage(String message) {
        // Update the message to the new message provided
        this.message = message;
    }
}