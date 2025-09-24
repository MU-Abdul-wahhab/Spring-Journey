# 🌱 Spring @Component and Lifecycle Annotations Example Project

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating how to use `@Component`, `@PostConstruct`, and `@PreDestroy` annotations to manage beans and their lifecycle in the IoC Container.

## 📖 Overview

This project demonstrates:
- Declaring beans using `@Component`
- Using `@PostConstruct` for initialization logic
- Using `@PreDestroy` for cleanup logic
- Retrieving beans by type or custom name from Spring `ApplicationContext`
- How Spring automatically manages bean lifecycle

> **Note:** `@Component` beans are detected automatically via `@ComponentScan` in a `@Configuration` class.

## 🧩 Example Beans

### Phone Bean (Full Example)

```java
@Component
public class Phone {

    private String brand;
    private String model;

    public void turnOn() {
        System.out.println("Phone is turned on");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Phone initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Phone destroyed");
    }
}
```

### Car Bean (Minimal Example)

```java
@Component("honda")
public class Car {

    public void startCar() {
        System.out.println("Car started");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Car initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car destroyed");
    }
}
```

### Laptop Bean (Minimal Example)

```java
@Component
public class Laptop {

    public void turnOn() {
        System.out.println("Laptop is on");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Laptop initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Laptop destroyed");
    }
}
```

## 🧩 Configuration Class

```java
@Configuration
@ComponentScan(basePackages = "com.spring.journey.beans")
public class Config {
    // Empty, component scanning handles bean registration
}
```

## 🧩 Main Class Example

```java
var context = new AnnotationConfigApplicationContext(Config.class);

Car car = context.getBean("honda", Car.class);
car.startCar();

Laptop laptop = context.getBean(Laptop.class);
laptop.turnOn();

Phone phone = context.getBean(Phone.class);
phone.turnOn();

// Close context to trigger @PreDestroy
context.close();
```

> **Note:** Closing the context triggers `@PreDestroy` methods of all beans.

## 🎯 Key Learnings

- Spring IoC Container manages bean lifecycle automatically
- `@Component` simplifies bean declaration without `@Bean` methods
- Lifecycle hooks (`@PostConstruct` & `@PreDestroy`) allow initialization and cleanup logic
- Beans can be retrieved by name or type
- Spring automatically injects dependencies (Dependency Injection)

## 💬 Final Thought

This project highlights how Spring manages your objects:

**"Spring manages your objects — you focus on the logic!"** 🌱