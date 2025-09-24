# 🌱 Spring @Bean and @Primary Example Project

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating how to use `@Bean` and `@Primary` annotations to manage multiple beans of the same type inside the IoC Container.

## 📖 Overview

This project helped me understand:
- Defining beans with `@Bean` in a `@Configuration` class
- Using `@Primary` to resolve conflicts when multiple beans of the same type exist
- Retrieving beans from the Spring `ApplicationContext`
- Handling multiple beans of the same type with custom bean names

> **Note:** `@Bean` methods are typically placed inside a class annotated with `@Configuration`, so Spring knows to process them and register the beans.

## 🧩 Example Code

### Configuration Class

```java
@Configuration
public class Config {

    @Bean(value = "apple")
    Phone apple() {
        Phone phone = new Phone();
        phone.setBrand("Apple");
        phone.setModel("Apple 11");
        return phone;
    }

    @Primary
    @Bean(value = "samsung")
    Phone samsung() {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("S20 Plus");
        return phone;
    }
}
```

### Retrieving Beans

```java
var context = new AnnotationConfigApplicationContext(Config.class);

// This will return the primary bean (Samsung)
// Note: If no bean had been marked with @Primary, 
// retrieving by type would throw NoUniqueBeanDefinitionException
Phone phone = context.getBean(Phone.class);
System.out.println("Primary Phone Brand: " + phone.getBrand());
System.out.println("Primary Phone Model: " + phone.getModel());
```

### Retrieving a Specific Bean by Name

```java
Phone apple = context.getBean("apple", Phone.class);
System.out.println("Apple Phone Brand: " + apple.getBrand());
System.out.println("Apple Phone Model: " + apple.getModel());
```

## 🚧 Common Issues

### Multiple `@Primary` Beans

If you mark more than one bean of the same type with @Primary, Spring will throw:

```text
NoUniqueBeanDefinitionException
```

**✅ Fix:** Ensure that only one bean of a type has the @Primary annotation, or retrieve a specific bean by its name instead.

## 🎯 Key Learnings

- Spring IoC Container manages object lifecycle
- `@Bean` annotation allows registering beans programmatically
- `@Primary` resolves conflicts when multiple beans of the same type exist
- Beans can be retrieved by type or name, enabling flexible dependency management
- Spring automatically injects dependencies where needed (Dependency Injection)

## 💬 Final Thought

This project clarified an important Spring principle:

**"You don't call Spring, Spring calls you!"** 🌱