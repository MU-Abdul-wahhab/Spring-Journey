package com.spring.journey.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component(value = "honda")
public class Car {

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

    public void startCar(){
        System.out.println("Car started");
    }

    @PostConstruct
    public void initialize(){
        System.out.println("Car initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Car destroyed");
    }

}
