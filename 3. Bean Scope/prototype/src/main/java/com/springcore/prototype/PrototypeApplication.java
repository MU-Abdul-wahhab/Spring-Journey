package com.springcore.prototype;

import com.springcore.prototype.beans.NotificationMessage;

import com.springcore.prototype.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);

        var context = new AnnotationConfigApplicationContext(Config.class);

        NotificationMessage msg1 = context.getBean(NotificationMessage.class);
        msg1.setMessage("Welcome to our platform!");
        msg1.setReceiver("user1@example.com");
        msg1.send();

        NotificationMessage msg2 = context.getBean(NotificationMessage.class);
        msg2.setMessage("Your password has been reset.");
        msg2.setReceiver("user2@example.com");
        msg2.send();

        System.out.println("msg1 == msg2 ? " + (msg1 == msg2));

    }
}