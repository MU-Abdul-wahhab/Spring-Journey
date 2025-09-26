package com.spring.journey.beans;

import com.spring.journey.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Phone {

    private String brand = "Samsung";
    private String model = "S24 Ultra";

    private final PhoneService phoneService;

    @Autowired
    public Phone(PhoneService phoneService) {
        this.phoneService = phoneService;
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

    public PhoneService getPhoneService() {
        return phoneService;
    }
}
