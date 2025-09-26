package com.spring.journey.beans;

import org.springframework.stereotype.Component;

@Component
public class OS {

    private String version = "Android 15";

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
