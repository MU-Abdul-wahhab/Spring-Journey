package com.spring.journey.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("user")
public class User {

    private String name = "Abdul wahhab";


    private final Phone phone;

    @Autowired
    public User(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }
}
