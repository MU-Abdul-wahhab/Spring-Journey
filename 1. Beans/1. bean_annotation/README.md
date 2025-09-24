# 🌱 Spring @Bean Introduction Project

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating how to use **`@Bean`** to let Spring manage objects inside the **IoC Container**.

## 📖 Overview

This project helped me understand:
- Defining beans with `@Bean` in a `@Configuration` class
- Retrieving objects from the Spring `ApplicationContext`
- Handling multiple beans of the same type
- Assigning custom bean names for clarity

## 🧩 Example Code

### Defining a Bean

```java
@Bean
Phone phone() {
    Phone apple = new Phone();
    apple.setBrand("Apple");
    apple.setModel("Apple 11 Pro Max");
    return apple;
}
```

### Retrieving a Bean

```java
Phone phone = context.getBean(Phone.class);
System.out.println(phone.getBrand()); // Apple
```

### Handling Multiple Beans
```java
Phone apple = context.getBean("apple", Phone.class);
System.out.println(apple.getBrand()); // Apple
```

## 🚧 Common Issues

### NoUniqueBeanDefinitionException

If you define two beans of the same type, Spring will throw:

```text
NoUniqueBeanDefinitionException
```

**✅ Fix:** Use method name or custom bean name:

```java
@Bean(value = "apple")
Phone apple() { 
    // bean implementation
}
```

## 🎯 Key Learnings

- Spring IoC Container manages object lifecycle
- `@Bean` annotation allows registering beans programmatically
- Beans can be retrieved by type or name, making dependency management easier

## 💬 Final Thought

This simple project gave me a "lightbulb moment" 💡 about Spring:

**"You don't call Spring, Spring calls you!"** 🌱