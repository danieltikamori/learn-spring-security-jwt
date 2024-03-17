package cc.tkmr.learnspringsecurityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityJwtApplication.class, args);
	}

}

// Use the following dependencies at spring initializer:
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
// https://mvnrepository.com/artifact/com.h2database/h2

// And JWT, not included in the initializer:
// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -> moved to:
//https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api

// Paste the following code at pom.xml:
//<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
//<dependency>
//    <groupId>io.jsonwebtoken</groupId>
//    <artifactId>jjwt-api</artifactId>
//    <version>0.12.5</version>
//</dependency>

// Update dependencies as it may look not found.

// Create the following packages to organize your code:
// controller
// dtos
// model
// repository
// security
// service

// Utility Classes
// SwaggerConfig - API documentation
// JWTObject - object that represents the token
// JWTCreator - creates the token, instantiates JWTObject

// Use the following for security:
// https://mvnrepository.com/artifact/org.springframework.security/spring-security-core



