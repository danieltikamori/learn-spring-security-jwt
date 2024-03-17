/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

// This Java file is in the package cc.tkmr.learnspringsecurityjwt
package cc.tkmr.learnspringsecurityjwt;

// Import necessary Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotate the class to indicate it's a Spring Boot application
@SpringBootApplication
public class LearnSpringSecurityJwtApplication {

	// Main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityJwtApplication.class, args);
	}

}

// Below are dependencies required for this project:

// Spring Boot starter security dependency
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security

// Spring Boot starter web dependency
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web

// Spring Boot starter data JPA dependency
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa

// H2 database dependency
// https://mvnrepository.com/artifact/com.h2database/h2

// JWT dependency (not included in the initializers):
// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt (now moved to https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api)

// Include the following in the pom.xml file for JJWT API:
//<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
//<dependency>
//    <groupId>io.jsonwebtoken</groupId>
//    <artifactId>jjwt-api</artifactId>
//    <version>0.11.5</version>
//</dependency>

// Remember to update dependencies as they may appear as not found.

// Organize your code into packages for better structure

// For security, use the following Spring security dependency:
// https://mvnrepository.com/artifact/org.springframework.security/spring-security-core