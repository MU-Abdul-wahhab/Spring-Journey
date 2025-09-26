package com.spring.journey.services;

import com.spring.journey.interfaces.Notification;
import com.spring.journey.interfaces.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneService {

    private final Notification notification;
    private final Storage storage;

    @Autowired
    public PhoneService(Notification notification, Storage storage) {
        this.notification = notification;
        this.storage = storage;
    }

    public void sendNotification() {
        System.out.println(notification.sendNotification());
    }

    public void storeData(){
        System.out.println(storage.storeData());
    }

}
