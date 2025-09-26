package com.spring.journey.implementation;

import com.spring.journey.interfaces.Storage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LocalStorage implements Storage {
    @Override
    public String storeData() {
        return "Saving Data in Local Storage";
    }
}
