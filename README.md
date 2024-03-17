# Authentication project using Spring Security, H2 database and Design Patterns in Java

This project is an example of how to use Spring Security with JWT token in Java. It also uses design patterns to simplify the code.
It is possible to adapt to use in PostgresSQL and MySQL databases.

## Table of Contents

- [Description](#description)
- [Installation](#installation)
- [Usage](#usage)
- [Conclusion](#conclusion)

## Description

This is an application that allows users to authenticate using Spring Security and data is stored at H2 in-memory database. Users can sign up, log in, and log out. Also, there are roles for each kind of users.

**IMPORTANT NOTE: Disable CSRF ONLY for development environment. In production, it should be enabled. In this example, CSRF is disabled as we are using localhost and H2 in-memory database.**
**IMPORTANT NOTE 2: For production, at WebSecurityConfig class,  `.requestMatchers(h2ConsolePath + "/**").permitAll()` must be eliminated. Development use only as it allow access to H2 console.**


## Dependencies and versions

- Spring Boot 3.2.3
- Spring Security 3.2.3
- Spring Data JPA 3.2.3
- H2 2.2.224
- Java 17
- Maven 4.0.0
- JWT 0.11.5

Updated versions may break the current application.

## Installation

```bash
$ mvn clean install
```

## Usage

```bash
$ mvn spring-boot:run
```

Open the browser and navigate to http://localhost:8080/h2-ui

Pay attention to the login page.

It should be like this in order to login successfully:
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:./testdb
User Name: sa
Password: [empty]

Click in Connect and verify if tables are created. It should have ROLES, USERS, etc.

We also need to add some rows into roles table before assigning any role to User.
Run following SQL insert statements:

```sql
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
Click on Run.

Then check the roles table:
```sql
SELECT * FROM roles;
```

Register some users with /signup API:

admin with ROLE_ADMIN
mod with ROLE_MODERATOR and ROLE_USER
danieltikamori with ROLE_USER

Open Postman, at URI http://localhost:8080/api/auth/signup, select POST method, Body, raw and send following this example JSON:

```json
{
"username": "admin",
"email": "admin@tkmr.cc",
"password": "792NfbiWv&aksG!Zb%hznrzc*84ZAhHupne5!Tse96$y@5vmeiFPB7n57oszT6n%%Sd^qfhRGcqbqcJrUDB@%r7ju!Xi&C7DKJShxvMR8cvi",
"role": ["admin", "mod", "user"]
}
```

Adapt to other users. username max length is 20 characters, email max length is 50 characters, Password max length is 120 characters, password will be hashed.
Admin and Moderator should have users role.

Check users and user_roles tables:

```sql
SELECT * FROM users;
SELECT * FROM user_roles;
```

Or:

```sql
SELECT * FROM USERS;
SELECT * FROM USER_ROLES;
```

Back to Postman:

Access public resource: GET http://localhost:8080/api/test/all

Access protected resource without Login: GET http://localhost:8080/api/test/user

Login an account: POST http://localhost:8080/api/auth/signin Select POST, Body, raw and send following this example JSON:

{
"username": "admin",
"password": "792NfbiWv&aksG!Zb%hznrzc*84ZAhHupne5!Tse96$y@5vmeiFPB7n57oszT6n%%Sd^qfhRGcqbqcJrUDB@%r7ju!Xi&C7DKJShxvMR8cvi"
}

Check the Cookies beside (response)Body, at the bottom of the Postman application.

Access ROLE_USER and ROLE_MODERATOR resource:
– GET /api/test/user
– GET /api/test/mod

Access ROLE_ADMIN resource: GET /api/test/admin, for non admin users, response will be 403 Forbidden.

Logout: POST http://localhost:8080/api/auth/signout

## For other databases - PostgreSQL and MySQL

– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:
```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties

Open `src/main/resources/application.properties`

- For PostgreSQL:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update

# App Properties
danieltikamori.app.jwtSecret= ==================>DanielTikamori=Architect<==================
danieltikamori.app.jwtExpirationMs= 86400000
```
- For MySQL
```
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

# App Properties
danieltikamori.app.jwtSecret= ==================>DanielTikamori=Architect<==================
danieltikamori.app.jwtExpirationMs= 86400000
```

## Conclusion

It can serve as a boilerplate for Spring Security projects.