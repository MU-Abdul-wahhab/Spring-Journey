# 🌱 Spring XML-Based IoC Container Example (Outdated Approach)

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A Spring project demonstrating bean configuration using XML and retrieving beans from the IoC Container.

> **Note:** XML configuration is considered outdated. Modern Spring projects typically use annotations (`@Component`, `@Bean`, `@Configuration`) for bean declaration and dependency injection.

## 📖 Overview

This project demonstrates:
- Declaring beans using XML configuration (`beans.xml`)
- Setting bean properties using `<property>` tags
- Retrieving beans by name and type from the Spring IoC Container

> **Tip:** Review the full project to see all beans and their properties in action.

## 🧩 Example Bean (Short)

```java
public class Car {
    private String brand;
    private String model;

    public void startCar() {
        System.out.println("Car started");
    }

    // Getters and setters omitted
}
```

## 🧩 XML Configuration Snippet

```xml
<bean id="toyota" class="com.spring.journey.beans.Car">
    <property name="brand" value="Toyota"/>
    <property name="model" value="Supra"/>
</bean>

<bean id="honda" class="com.spring.journey.beans.Car">
    <property name="brand" value="Honda"/>
    <property name="model" value="Civic"/>
</bean>
```

> **Tip:** Review the project's `beans.xml` for all Car, Laptop, and Phone beans.

## 🧩 Main Class Snippet

```java
var context = new ClassPathXmlApplicationContext("beans.xml");

Car honda = context.getBean("honda", Car.class);
System.out.println("Car Brand: " + honda.getBrand());

Phone apple = context.getBean("apple", Phone.class);
System.out.println("Phone Brand: " + apple.getBrand());

context.close();
```

## 🚧 Notes

- XML-based configuration works but is verbose and harder to maintain
- Modern Spring applications use annotations for simplicity
- Beans can be retrieved by name or type, just like annotation-based beans

## 🎯 Key Learnings

- XML was the original way to configure Spring applications
- Bean definitions are centralized in XML files
- Property injection is done through XML configuration
- The same IoC container principles apply regardless of configuration method

## 💬 Final Thought

This project illustrates classic Spring IoC. For a full understanding, review the complete project:

**"XML works, but annotations are the future!"** 🌱