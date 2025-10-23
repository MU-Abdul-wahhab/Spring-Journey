# 🧠 Spring Core – Request Scope Example

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Bean%20Scope-Request-blue?style=flat-square)

## 📘 Overview

This project demonstrates the **Request Scope** in **Spring Core** using a simple and practical example — `UserSession`.  
Each HTTP request gets a **new instance** of the `UserSession` bean, ensuring data isolation between different requests.

In this example, we simulate a login and user tracking process, showing how the request-scoped bean behaves in a web environment.

## 🧩 What is Request Scope?

In Spring, a bean with **request scope** is created **once per HTTP request** and destroyed automatically after the request is completed.  
This is typically used for web applications where each user request should be handled separately.

## 🧠 Example Code

### UserSession.java

```java
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class UserSession {

    private String username;

    public UserSession() {
        System.out.println("New UserSession bean created for request");
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
```

### UserController.java

```java
@RestController
public class UserController {

    private final UserSession userSession;

    public UserController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username) {
        userSession.setUsername(username);
        return "Welcome, " + userSession.getUsername() + "!";
    }

    @GetMapping("/whoami")
    public String whoAmI() {
        return "Current User: " + (userSession.getUsername() != null ? userSession.getUsername() : "Guest");
    }
}
```

## ⚙️ Running Instructions

Make sure you have the Spring Web dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Run the application:

```bash
mvn spring-boot:run
```

Access the endpoints:

```
GET http://localhost:8080/login?username=Wahhab
GET http://localhost:8080/whoami
```

## 🧪 Sample Output

### Request 1
```
GET /login?username=Wahhab
→ "Welcome, Wahhab!"
```

### Request 2
```
GET /whoami
→ "Current User: Guest"
```

Each request creates a new UserSession bean, ensuring the state is not shared between requests.

## 🎯 Key Learnings

- Request Scope beans are created per HTTP request
- Best suited for request-specific data like request metadata or temporary session info
- Spring automatically destroys them once the request completes
- Must be used in a web-aware Spring application context

## 🚧 Common Use Cases

- User authentication per request
- Request-specific logging or tracking
- Temporary form data processing
- Request metadata storage

## 💬 Final Thought

Request scope helps achieve clean separation of per-request logic in Spring applications, ensuring your components are stateless, safe, and easy to test.

**"Fresh instance for every request — perfect for web applications!"** 🌐