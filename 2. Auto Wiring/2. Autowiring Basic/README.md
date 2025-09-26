# 🌱 Spring @Autowired Basics – Phone Example

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A simple Spring project demonstrating dependency injection using `@Autowired`. This example shows three types of wiring: field injection, setter injection, and constructor injection.

## 📖 Overview

This project helps you understand:
- Wiring dependencies using `@Autowired` at field, setter, and constructor levels
- Why constructor injection is the recommended approach
- Optional vs mandatory dependencies
- How Spring IoC container automatically manages object creation

## 🧩 Example Code

### BackPanel Bean

```java
@Component
public class BackPanel {
    private String colour = "Black";

    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }
}
```

### Display Bean

```java
@Component
public class Display {
    private String type = "OLED";

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
```

### OS Bean

```java
@Component
public class OS {
    private String version = "Android 15";

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
}
```

### Phone Bean

```java
@Component
public class Phone {
    private String brand = "Samsung";
    private String model = "S24 Ultra";

    @Autowired               // Field-level injection
    private BackPanel backPanel;

    private Display display;
    private final OS os;

    @Autowired               // Constructor-level injection
    public Phone(OS os){
        this.os = os;
    }

    @Autowired               // Setter-level injection
    public void setDisplay(Display display) {
        this.display = display;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public BackPanel getBackPanel() { return backPanel; }
    public Display getDisplay() { return display; }
    public OS getOs() { return os; }
}
```

### Configuration Class

```java
@Configuration
@ComponentScan(basePackages = "com.spring.journey.beans")
public class Config { }
```

### Main Class

```java
var context = new AnnotationConfigApplicationContext(Config.class);
Phone phone = context.getBean(Phone.class);

System.out.println("Phone Brand: " + phone.getBrand());
System.out.println("Phone Model: " + phone.getModel());
System.out.println("Phone BackPanel Colour: " + phone.getBackPanel().getColour());
System.out.println("Phone Display Type: " + phone.getDisplay().getType());
System.out.println("Phone OS Version: " + phone.getOs().getVersion());
```

### 🖥️ Sample Output

```
Phone Brand: Samsung
Phone Model: S24 Ultra
Phone BackPanel Colour: Black
Phone Display Type: OLED
Phone OS Version: Android 15
```

## 🚧 Common Issues

### Missing Bean
Spring will fail at startup if a required bean is not available.

### Multiple Beans of Same Type
Spring will throw:

```text
NoUniqueBeanDefinitionException
```

**✅ Fix:** Use `@Primary` or `@Qualifier` annotations to resolve ambiguity.

## 🎯 Key Learnings

- **Field Injection:** Quick, but harder to test; less recommended
- **Setter Injection:** Useful for optional dependencies; better testability
- **Constructor Injection:** Best practice; ensures immutable, mandatory dependencies
- Spring IoC automatically manages bean creation and wiring

## 💬 Final Thought

This project demonstrates how `@Autowired` makes Spring applications modular, flexible, and testable.

**"Choose constructor injection for best practices, but know all three options for learning!"** 🌱