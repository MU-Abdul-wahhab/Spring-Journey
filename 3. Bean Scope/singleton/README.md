# ☕ Spring Core — Singleton Bean Scope Example

![Spring](https://img.shields.io/badge/Spring%20Core-6.0+-green?style=for-the-badge&logo=spring)
![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Build-Maven-blue?style=for-the-badge&logo=apachemaven)

## 🧩 Overview

This repository demonstrates the **Singleton Bean Scope** concept in the **Spring Core Framework** using a simple and practical example — an `EmailService` shared across the entire application.

In Spring, **singleton scope** means **only one instance** of a bean is created and shared within the application context, regardless of how many times it's requested.

## 🚀 Example Explanation

### Scenario
An application has one common **EmailService** provider (e.g., Amazon SES) that handles all outgoing emails.  
No matter how many components use this service, only **one instance** of it should exist in memory.

### Flow
1. Spring scans and creates the `EmailService` bean.
2. Two objects are fetched from the context.
3. Both references point to the same bean instance — proving singleton behavior.

## 🧠 Example Code

### EmailService.java

```java
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class EmailService {
    private String EmailServiceProvider = "Amazon SES";

    public String getEmailServiceProvider() {
        return EmailServiceProvider;
    }
}
```

### SingletonApplication.java

```java
@SpringBootApplication
public class SingletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingletonApplication.class, args);

        var context = new AnnotationConfigApplicationContext(config.class);

        EmailService emailService1 = context.getBean(EmailService.class);
        EmailService emailService2 = context.getBean(EmailService.class);

        if (emailService1 == emailService2) {
            System.out.println("Email Service is already present in Singleton Application");
        }
    }
}
```

### Output

```
Email Service is already present in Singleton Application
```

## 🎯 Key Learnings

- Singleton is the **default scope** in Spring
- Only one instance of the bean is created per Spring IoC container
- All requests for that bean return the same instance
- Suitable for stateless services and shared resources

## 🚧 Common Use Cases

- Service classes (EmailService, UserService, etc.)
- Configuration classes
- Data sources and connection pools
- Utility classes

## 💬 Final Thought

The Singleton scope is the default and most commonly used scope in Spring applications. It ensures performance and consistency by maintaining one shared instance throughout the app lifecycle.

**"One instance to rule them all — efficiently and consistently!"** ☕