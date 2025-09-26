package com.spring.journey.implementation;


import com.spring.journey.interfaces.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {
    @Override
    public String sendNotification() {
        return "Sending Notification via Email ";
    }
}
