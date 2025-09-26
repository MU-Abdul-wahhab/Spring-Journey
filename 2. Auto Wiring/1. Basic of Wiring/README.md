# 🌱 Spring Method Parameter Wiring – Phone & User

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating dependency injection (DI) using method parameters. This example shows how Spring automatically wires beans without using `@Autowired` annotations.

## 📖 Overview

This project helps you understand:
- How Spring injects dependencies via method parameters
- Type-safe wiring of beans
- Avoiding boilerplate `@Autowired` annotations
- Simplifying object creation and management using Spring IoC container

## 🧩 Example Code

### Phone Bean

```java
public class Phone {
    private String brand;
    private String model;

    // Getters & Setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
```

### User Bean

```java
public class User {
    private String name;
    private Phone phone;

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Phone getPhone() { return phone; }
    public void setPhone(Phone phone) { this.phone = phone; }
}
```

### Configuration Class

```java
@Configuration
public class Config {

    @Bean
    Phone samsung() {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("S24 Ultra");
        return phone;
    }

    @Bean
    User samsungUser(Phone phone) {
        User user = new User();
        user.setName("Abdul");
        user.setPhone(phone); // Spring injects Phone automatically
        return user;
    }
}
```

## 🚀 Running the App

```java
var context = new AnnotationConfigApplicationContext(Config.class);
User user = context.getBean(User.class);

System.out.println("User Name - " + user.getName());
System.out.println("User's Phone Brand - " + user.getPhone().getBrand());
System.out.println("User's Phone Model - " + user.getPhone().getModel());

context.close();
```

### 🖥️ Sample Output

```
User Name - Abdul
User's Phone Brand - Samsung
User's Phone Model - S24 Ultra
```

## 🚧 Common Issues

### Missing Bean
Spring will fail at startup if a required bean is missing.

### Multiple Beans of Same Type
If multiple beans of the same type exist, Spring cannot decide which one to inject and throws:

```text
NoUniqueBeanDefinitionException
```

## 🎯 Key Learnings

- Method parameter wiring is type-safe
- Avoids `@Autowired` and boilerplate code
- Spring IoC manages object creation automatically
- Early detection of missing dependencies

## 💬 Final Thought

Spring makes it easy to wire objects without manually creating them. Using method parameter wiring keeps your code clean, modular, and testable.

**"Don't create objects manually — let Spring wire them for you!"** 🌱

## 📌 References

- [Spring @Bean Documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)
- [Spring @Configuration and Dependency Injection – Baeldung](https://www.baeldung.com/spring-annotation-bean-configuration)
- [Spring IoC Container Overview – Baeldung](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)