package com.springcore.request.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserSession {
    private String name;

    public UserSession() {
        System.out.println("A New UserSession Object has Created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
