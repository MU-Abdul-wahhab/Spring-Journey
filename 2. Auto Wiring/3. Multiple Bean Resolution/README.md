# 📱 Spring Bean Wiring – Multiple Beans (Phone Example)

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

A Spring project demonstrating how the IoC container resolves multiple beans of the same type using:
- Variable/parameter name matching
- `@Primary` annotation
- `@Qualifier` annotation

## 📖 Overview

This project shows how Spring decides which bean to inject when multiple candidates exist:
1. Spring first checks if the parameter/variable name matches a bean name
2. If no match is found, Spring falls back to the `@Primary` annotation
3. If ambiguity still exists, `@Qualifier` helps to explicitly select the bean

This ensures flexible and predictable bean wiring in real-world applications.

## 🧩 Example Code

### Phone Bean

```java
public class Phone {
    private String brand = "Samsung";
    private String model = "S24 Ultra";
    private Display display;
    private BackPanel backPanel;
    private OS os;

    // Getters & Setters
    public Display getDisplay() { return display; }
    public void setDisplay(Display display) { this.display = display; }
    public BackPanel getBackPanel() { return backPanel; }
    public void setBackPanel(BackPanel backPanel) { this.backPanel = backPanel; }
    public OS getOs() { return os; }
    public void setOs(OS os) { this.os = os; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
}
```

### Display Bean

```java
public class Display {
    private String type;
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
```

### BackPanel Bean

```java
public class BackPanel {
    private String colour;
    
    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }
}
```

### OS Bean

```java
public class OS {
    private String version;
    
    public String getOS() { return version; }
    public void setOS(String version) { this.version = version; }
}
```

### Configuration Class

```java
@Configuration
public class Config {

    @Bean("oled")
    Display oled() {
        Display oled = new Display();
        oled.setType("OLED");
        return oled;
    }

    @Bean("lcd")
    Display lcd() {
        Display lcd = new Display();
        lcd.setType("LCD");
        return lcd;
    }

    @Bean
    Phone phone(Display oled, BackPanel panel, @Qualifier("14") OS os) {
        Phone phone = new Phone();
        phone.setDisplay(oled);      // Parameter name matches bean
        phone.setBackPanel(panel);   // Uses @Primary
        phone.setOs(os);             // Uses @Qualifier
        return phone;
    }

    @Bean
    @Primary
    BackPanel panel1() {
        BackPanel panel1 = new BackPanel();
        panel1.setColour("Black");
        return panel1;
    }

    @Bean
    BackPanel panel2() {
        BackPanel panel2 = new BackPanel();
        panel2.setColour("Gray");
        return panel2;
    }

    @Bean("14")
    OS os1() {
        OS os1 = new OS();
        os1.setOS("Android 14");
        return os1;
    }

    @Bean("15")
    OS os2() {
        OS os2 = new OS();
        os2.setOS("Android 15");
        return os2;
    }
}
```

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        Phone phone = context.getBean(Phone.class);

        // 1. Variable/parameter name matches bean name
        System.out.println("Phone Display Type " + phone.getDisplay().getType());

        // 2. Fallback: @Primary
        System.out.println("Phone BackPanel Colour " + phone.getBackPanel().getColour());

        // 3. Final: @Qualifier
        System.out.println("Phone Android Version " + phone.getOs().getOS());
        
        context.close();
    }
}
```

## 🚀 Running the App

```java
var context = new AnnotationConfigApplicationContext(Config.class);
Phone phone = context.getBean(Phone.class);
```

### 🖥️ Sample Output

```
Phone Display Type OLED
Phone BackPanel Colour Black
Phone Android Version Android 14
```

## 🚧 Common Issues

### ❌ NoUniqueBeanDefinitionException
Occurs when Spring finds multiple beans of the same type but cannot decide which one to inject.

**✅ Solution:** Use `@Primary`, `@Qualifier`, or match bean names to parameter names.

### ❌ UnsatisfiedDependencyException
Thrown when Spring cannot find a suitable bean to inject.

**✅ Solution:** Ensure all required beans are declared in the configuration.

## 🎯 Key Learnings

- Spring tries name-based matching first
- `@Primary` defines the default bean when multiple candidates exist
- `@Qualifier` resolves ambiguity explicitly
- Dependency resolution is predictable and layered

## 💬 Final Thought

This project illustrates Spring's three-step mechanism for resolving multiple beans. It helps you write modular, maintainable, and conflict-free configurations.

**"When in doubt, qualify it."** 🎯

## 📌 References

- [Spring @Bean Documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)