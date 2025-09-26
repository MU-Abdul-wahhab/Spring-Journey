package com.spring.journey.implementation;

import com.spring.journey.interfaces.Storage;
import org.springframework.stereotype.Component;

@Component
public class CloudStorage implements Storage {
    @Override
    public String storeData() {
        return "Saving File in Cloud Storage";
    }
}
