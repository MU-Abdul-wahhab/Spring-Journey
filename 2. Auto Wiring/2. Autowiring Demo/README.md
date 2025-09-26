# 🌱 Spring Dependency Injection Example – Phone & User

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating Dependency Injection (DI) using `@Component`, `@Autowired`, interfaces, and multiple implementations.

## 📖 Overview

This project helped me understand:
- How Spring manages dependencies using constructor injection
- Using interfaces with multiple implementations
- Resolving conflicts with `@Primary`
- Wiring beans across multiple layers (User → Phone → PhoneService → Notification/Storage)
- How Spring IoC container simplifies object creation and management

## 🧩 Example Code

### User → Phone → PhoneService Dependency Chain

```java
@Component("user")
public class User {
    private String name = "Abdul wahhab";
    private final Phone phone;

    @Autowired
    public User(Phone phone) {
        this.phone = phone;
    }
    
    // Getters
    public String getName() { return name; }
    public Phone getPhone() { return phone; }
}
```

```java
@Component
public class Phone {
    private String brand = "Samsung";
    private String model = "S24 Ultra";
    private final PhoneService phoneService;

    @Autowired
    public Phone(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
    
    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public PhoneService getPhoneService() { return phoneService; }
}
```

```java
@Component
public class PhoneService {
    private final Notification notification;
    private final Storage storage;

    @Autowired
    public PhoneService(Notification notification, Storage storage) {
        this.notification = notification;
        this.storage = storage;
    }
    
    public void sendNotification() {
        System.out.println(notification.sendNotification());
    }
    
    public void storeData() {
        System.out.println(storage.storeData());
    }
}
```

### Multiple Implementations with Interfaces

```java
public interface Notification {
    String sendNotification();
}

@Component
@Primary
public class SMSNotification implements Notification {
    public String sendNotification() {
        return "Sending Notification via SMS";
    }
}

@Component
public class EmailNotification implements Notification {
    public String sendNotification() {
        return "Sending Notification via Email";
    }
}
```

```java
public interface Storage {
    String storeData();
}

@Component
@Primary
public class LocalStorage implements Storage {
    public String storeData() {
        return "Saving Data in Local Storage";
    }
}

@Component
public class CloudStorage implements Storage {
    public String storeData() {
        return "Saving File in Cloud Storage";
    }
}
```

## 🚀 Running the App

```java
var context = new AnnotationConfigApplicationContext(Config.class);

User user = context.getBean("user", User.class);

System.out.println("User name: " + user.getName());
System.out.println("Phone: " + user.getPhone().getBrand() + " " + user.getPhone().getModel());

user.getPhone().getPhoneService().sendNotification();
user.getPhone().getPhoneService().storeData();

context.close();
```

### 🖥️ Sample Output
```
User name: Abdul wahhab
Phone: Samsung S24 Ultra
Sending Notification via SMS
Saving Data in Local Storage
```

## 🚧 Common Issues

### Multiple Implementations

If more than one bean implements the same interface, Spring will throw:

```text
NoUniqueBeanDefinitionException
```

**✅ Fix:**
- Use `@Primary` to mark a default implementation, OR
- Retrieve by bean name instead of type.

## 🎯 Key Learnings

- Constructor-based dependency injection is clean and test-friendly
- `@Component` + `@Autowired` removes boilerplate object creation
- `@Primary` resolves conflicts when multiple beans of the same type exist
- Spring IoC enables flexible and swappable dependencies (e.g., SMS ↔ Email, Local ↔ Cloud)
- Interface-based programming promotes loose coupling

## 💬 Final Thought

This project demonstrates how Spring Dependency Injection makes applications more modular, flexible, and testable.

**"Don't create objects manually — let Spring wire them for you!"** 🌱