package com.spring.journey.main;

import com.spring.journey.beans.User;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);

        User user = context.getBean(User.class);
        System.out.println("User Name - "+user.getName());
        System.out.println("User's Phone Brand - "+user.getPhone().getBrand());
        System.out.println("User's Phone Model - "+user.getPhone().getModel());

    }
}