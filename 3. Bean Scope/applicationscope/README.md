# 🧩 Spring Core – Application Scope Demo

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring](https://img.shields.io/badge/Spring%20Core-6.x-brightgreen.svg)
![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)

## 🧠 Overview
This project demonstrates the **Application Scope** in **Spring Core**.  
It shows how a bean annotated with `@ApplicationScope` is created **only once per application** and shared across all requests and users for the lifetime of the application context.

## 🚀 How It Works
- The `AppInfo` class is annotated with:
  ```java
  @Component
  @ApplicationScope
  ```
- This ensures that only one instance of `AppInfo` is created and shared for the entire application lifecycle.
- The `TestController` injects this bean using constructor injection and exposes two endpoints.

## 🧠 Example Code

### AppInfo.java
```java
@Component
@ApplicationScope
public class AppInfo {
    
    private String appName = "ApplicationScope Demo Application";
    private String version = "1.0";
    
    public AppInfo() {
        System.out.println("A New AppInfo Bean Created (Application Scope)");
    }
    
    public String getAppName() {
        return appName;
    }
    
    public String getVersion() {
        return version;
    }
}
```

### TestController.java
```java
@RestController
public class TestController {
    
    private final AppInfo appInfo;
    
    public TestController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }
    
    @GetMapping("/app-name")
    public String getAppName() {
        return appInfo.getAppName();
    }
    
    @GetMapping("/app-version")
    public String getAppVersion() {
        return appInfo.getVersion();
    }
}
```

## 📊 Endpoints

| Endpoint | Description | Response Example |
|----------|-------------|------------------|
| `/app-name` | Returns the application name | "ApplicationScope Demo Application" |
| `/app-version` | Returns the application version | "1.0" |

## 🧪 Sample Output

### Console
```
A New AppInfo Bean Created (Application Scope)
```
➡️ This line appears only once, proving that the bean is created a single time.

### API Responses
```
GET /app-name
→ ApplicationScope Demo Application

GET /app-version
→ 1.0
```

## 🚀 Test the Endpoints
```
http://localhost:8080/app-name
http://localhost:8080/app-version
```

## 🎯 Key Learning

- **@ApplicationScope**: Defines a bean that is created once for the entire application context
- Useful for global configurations, constants, or caches
- Contrasts with `@RequestScope` or `@SessionScope`, which are tied to a specific HTTP request or session

## 💡 Final Thought

This demo provides a simple yet powerful example of how Spring manages bean scopes effectively — helping developers design efficient, context-aware applications.

**"One bean, entire application — perfect for global configuration!"** 🌐