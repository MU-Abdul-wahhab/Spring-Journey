package com.spring.journey.implementation;


import com.spring.journey.interfaces.Notification;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSNotification implements Notification {
    @Override
    public String sendNotification() {
        return "Sending Notification via SMS";
    }
}
