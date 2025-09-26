package com.spring.journey.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Phone {
    private String brand = "Samsung";
    private String model = "S24 Ultra";
    private Display display;

    public BackPanel getBackPanel() {
        return backPanel;
    }

    public OS getOs() {
        return os;
    }

    @Autowired
    private BackPanel backPanel;

    private final OS os;

    @Autowired
    public Phone(OS os) {
        this.os = os;
    }

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

    public Display getDisplay() {
        return display;
    }

    @Autowired
    public void setDisplay(Display display) {
        this.display = display;
    }
}
