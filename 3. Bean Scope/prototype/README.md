# 📩 Spring Core — Prototype Bean Scope Example

![Spring](https://img.shields.io/badge/Spring%20Core-6.0+-green?style=for-the-badge&logo=spring)
![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Build-Maven-blue?style=for-the-badge&logo=apachemaven)

## 🧩 Overview

This repository demonstrates the **Prototype Bean Scope** concept in the **Spring Core Framework** using a simple example — a `NotificationMessage` bean.

In Spring, **prototype scope** means **a new bean instance is created every time** it is requested from the application context.

## 🚀 Example Explanation

### Scenario
Every time a notification is sent, we need a **fresh NotificationMessage object** because each message has **different content, receiver, and timestamp**.

### Flow
1. Spring scans and creates the `NotificationMessage` bean whenever requested.
2. Multiple components can request this bean, each receiving **a new instance**.
3. Comparing two objects confirms they are **different instances**.

## 🧠 Example Code

### NotificationMessage.java

```java
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NotificationMessage {

    private String message;
    private String receiver;

    public NotificationMessage() {
        System.out.println("📩 New NotificationMessage instance created!");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void send() {
        System.out.println("Sending '" + message + "' to " + receiver);
    }
}
```

### PrototypeApplication.java

```java
@SpringBootApplication
public class PrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);

        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationMessage msg1 = context.getBean(NotificationMessage.class);
        msg1.setMessage("Welcome to our platform!");
        msg1.setReceiver("user1@example.com");
        msg1.send();

        NotificationMessage msg2 = context.getBean(NotificationMessage.class);
        msg2.setMessage("Your password has been reset.");
        msg2.setReceiver("user2@example.com");
        msg2.send();

        System.out.println("msg1 == msg2 ? " + (msg1 == msg2));
        
        context.close();
    }
}
```

### Output

```
📩 New NotificationMessage instance created!
Sending 'Welcome to our platform!' to user1@example.com
📩 New NotificationMessage instance created!
Sending 'Your password has been reset.' to user2@example.com
msg1 == msg2 ? false
```

## 🎯 Key Learning

- Prototype scope creates a new instance every time the bean is requested
- Useful for stateful beans or temporary objects
- Contrasts with Singleton scope, which shares one instance
- Ideal use cases: messages, tasks, forms, request objects, or any per-operation data

## 🚧 Common Use Cases

- Request-specific data objects
- Temporary processing objects
- Stateful services
- Objects with mutable state
- Any scenario where shared state would cause issues

## 💬 Final Thought

Prototype beans are perfect when each operation requires a fresh, independent object. Spring ensures that every request returns a new object, preventing accidental shared state.

**"New instance for every request — perfect for stateful operations!"** 📩