# 🧠 Spring Core – Session Scope Example

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Bean%20Scope-Session-blue?style=flat-square)

## 📘 Overview

This project demonstrates the **Session Scope** in **Spring Core** using a simple and practical example — `UserSession`.  
A new `UserSession` bean is created for each **unique HTTP session**, and the same instance is reused throughout that session.

This helps maintain **user-specific data** (like username, preferences, or login info) across multiple requests within the same session.

## 🧩 What is Session Scope?

In Spring, a bean with **session scope** is created **once per HTTP session** and remains active until that session expires or is invalidated.  
This makes it ideal for storing **user-related state** in web applications where a single user may make multiple requests.

## 🧠 Example Code

### UserSession.java

```java
@Component
@SessionScope
public class UserSession {
    private String name;

    public UserSession() {
        System.out.println("A New UserSession Object has Created");
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### UserController.java

```java
@RestController
public class UserController {

    private final UserSession userSession;

    @Autowired
    public UserController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username) {
        userSession.setName(username);
        return "Welcome, " + userSession.getName() + "!";
    }

    @GetMapping("/whoami")
    public String whoAmI() {
        return "Current User: " + (userSession.getName() != null ? userSession.getName() : "Guest");
    }
}
```

## ⚙️ Running Instructions

Make sure your project has the Spring Web dependency in `pom.xml`:

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

### Request 1 (Login)
```
GET /login?username=Wahhab
→ "Welcome, Wahhab!"
```

### Request 2 (Same Session)
```
GET /whoami
→ "Current User: Wahhab"
```

### New Browser or Incognito Session
```
GET /whoami
→ "Current User: Guest"
```

💡 Each browser session (or incognito window) creates a new UserSession bean, which persists across multiple requests in that same session.

## 🎯 Key Learnings

- Session Scope beans are created per HTTP session
- They persist across multiple requests from the same client
- Perfect for user login info, shopping cart, or preferences
- Each user (session) gets a unique bean instance

## 💬 Final Thought

Session scope makes it easy to manage user-specific state in Spring applications, ensuring that every user's data remains isolated and persists across their session journey.

**"One session, one bean — perfect for user-specific state management!"** 🔐