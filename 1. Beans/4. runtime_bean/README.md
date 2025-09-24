# 🌱 Spring Programmatic Bean Registration Example

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A Spring project demonstrating how to register beans programmatically using `registerBean()` and retrieve them from the IoC Container.

## 📖 Overview

This project demonstrates:
- Creating bean instances dynamically using Suppliers
- Registering beans programmatically in the Spring `ApplicationContext`
- Retrieving beans by name or type
- Handling missing beans gracefully with exceptions (`NoSuchBeanDefinitionException`)

> **Note:** This approach is useful when you want Spring to manage objects created at runtime, rather than defining them via `@Bean` or `@Component`.

## 🧩 Example Beans

### Car Class
```java
public class Car {
    private String brand;
    private String model;

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

    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
```

### Laptop Class
```java
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

### Phone Class
```java
public class Phone {
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

## 🧩 Configuration Class

```java
@Configuration
public class Config {
    // Empty, beans are registered programmatically
}
```

## 🧩 Main Class Example

```java
var context = new AnnotationConfigApplicationContext(Config.class);

// Create bean suppliers
Supplier<Car> toyota = () -> {
    Car car = new Car();
    car.setBrand("Toyota");
    car.setModel("Supra");
    return car;
};

Car honda = new Car();
honda.setBrand("Honda");
honda.setModel("Civic");

Supplier<Car> hondaCar = () -> honda;

// Register beans programmatically
context.registerBean("toyota", Car.class, toyota);
context.registerBean("honda", Car.class, hondaCar);

// Attempt to retrieve bean
String userInput = "benz";

try {
    Car car = context.getBean(userInput, Car.class);
    System.out.println("Getting Car Brand From Spring Context: " + car.getBrand());
    System.out.println("Getting Car Model From Spring Context: " + car.getModel());
} catch (NoSuchBeanDefinitionException e) {
    System.out.println("Spring Context does not have a bean called " + userInput);
}

// Close context to trigger @PreDestroy
context.close();
```

## 🚧 Common Issues

### NoSuchBeanDefinitionException

If you try to retrieve a bean that hasn't been registered, Spring will throw:

```text
NoSuchBeanDefinitionException
```

**✅ Fix:** Always handle the exception when retrieving beans dynamically:

```java
try {
    Car car = context.getBean(userInput, Car.class);
    // Use the bean
} catch (NoSuchBeanDefinitionException e) {
    System.out.println("Bean not found: " + userInput);
}
```

## 🎯 Key Learnings

- Programmatic registration allows dynamic, runtime-controlled beans
- Spring IoC container still manages lifecycle hooks (`@PostConstruct` & `@PreDestroy`)
- Beans can be retrieved safely with exception handling
- Flexibility of Spring increases when combining runtime creation with IoC
- `Supplier` interface provides a way to define bean creation logic

## 💬 Final Thought

This project shows how Spring can manage dynamically created objects, not just those declared in `@Bean` or `@Component`:

**"Spring can manage what you create at runtime — full IoC control!"** 🌱