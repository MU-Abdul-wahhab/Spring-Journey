# 📱 Spring Bean Resolution Order

![Java](https://img.shields.io/badge/Java-17-blue)  
![Spring](https://img.shields.io/badge/Spring-7.0.0--M9-green)  
![License](https://img.shields.io/badge/License-MIT-yellow)

This project demonstrates how **Spring resolves multiple bean candidates** when injecting dependencies.

## 🔑 Key Mechanisms

### 1️⃣ Variable Name ↔ Bean Name Matching
Spring matches the parameter/field name with the bean name.

```java
@Bean("oled")
Display oled() {
    Display display = new Display();
    display.setType("OLED");
    return display;
}

@Bean("lcd")
Display lcd() {
    Display display = new Display();
    display.setType("LCD");
    return display;
}

@Bean
Phone phone(Display oled, BackPanel panel, @Qualifier("14") OS os) {
    Phone phone = new Phone();
    phone.setDisplay(oled);  // Matches bean named "oled"
    return phone;
}
```

📌 Here, `Display oled` matches the bean named "oled".

### 2️⃣ @Primary Annotation
If variable name matching fails, Spring looks for a bean marked with `@Primary`.

```java
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
```

📌 `BackPanel panel1` is chosen because it is `@Primary`.

### 3️⃣ @Qualifier Annotation
If multiple beans still exist, `@Qualifier` is used to specify exactly which one to inject.

```java
@Bean("14")
OS os1() {
    OS os1 = new OS();
    os1.setVersion("Android 14");
    return os1;
}

@Bean("15")
OS os2() {
    OS os2 = new OS();
    os2.setVersion("Android 15");
    return os2;
}

@Bean
Phone phone(Display oled, BackPanel panel, @Qualifier("14") OS os) {
    Phone phone = new Phone();
    phone.setOs(os);  // Uses OS bean with qualifier "14"
    return phone;
}
```

📌 `@Qualifier("14")` ensures the bean "14" (Android 14) is selected.

## 🖥️ Output

```
Phone Display Type: OLED
Phone BackPanel Colour: Black
Phone Android Version: Android 14
```

## 🎯 Resolution Order Summary

1. **Variable Name Matching** - Spring tries to match parameter names with bean names
2. **@Primary Annotation** - If name matching fails, uses the primary bean
3. **@Qualifier Annotation** - Explicitly specifies which bean to use
4. **Exception** - If ambiguity remains, Spring throws `NoUniqueBeanDefinitionException`

## 💬 Final Thought

Understanding Spring's bean resolution order helps write cleaner, more predictable dependency injection code.

**"Spring's resolution order: Name → Primary → Qualifier → Exception!"** 🌱

## 📖 References

- [Spring Docs – Dependency Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-dependencies)
- [Spring Docs – @Primary Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html)
- [Spring Docs – @Qualifier Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html)