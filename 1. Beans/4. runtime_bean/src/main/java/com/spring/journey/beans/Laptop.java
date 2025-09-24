package com.spring.journey.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class Laptop {

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
        System.out.println("Laptop is on");
    }

    @PostConstruct
    public void initialize(){
        System.out.println("Laptop initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Laptop destroyed");
    }
}
