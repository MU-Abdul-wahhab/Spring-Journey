package com.springcore.prototype.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NotificationMessage {

    private String message;
    private String receiver;

    public NotificationMessage() {
        System.out.println("New NotificationMessage instance created!");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void send() {
        System.out.println("Sending '" + message + "' to " + receiver);
    }
}

