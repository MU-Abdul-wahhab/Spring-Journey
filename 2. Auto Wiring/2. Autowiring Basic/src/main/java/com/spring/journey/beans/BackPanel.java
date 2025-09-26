package com.spring.journey.beans;

import org.springframework.stereotype.Component;

@Component
public class BackPanel {

    private String colour = "Black";

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
