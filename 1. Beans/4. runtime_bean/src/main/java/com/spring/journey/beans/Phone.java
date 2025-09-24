package com.spring.journey.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class Phone {

    private String brand;
    private String model;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void turnOn(){
        System.out.println("Phone is turned on");
    }

    @PostConstruct
    public void initialize(){
        System.out.println("Phone initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Phone destroyed");
    }
}
