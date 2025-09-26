package com.spring.journey.beans;

import org.springframework.stereotype.Component;

@Component
public class Display {
    private String type = "OLED";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
