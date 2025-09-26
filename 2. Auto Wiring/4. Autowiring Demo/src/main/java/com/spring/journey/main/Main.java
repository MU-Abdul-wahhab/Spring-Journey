package com.spring.journey.main;

import com.spring.journey.beans.User;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);

        User user = context.getBean("user", User.class);
        System.out.println("User name " +user.getName());
        System.out.println("User Phone Brand - " + user.getPhone().getBrand());
        System.out.println("User Phone Model - " + user.getPhone().getModel());

        user.getPhone().getPhoneService().sendNotification();
        user.getPhone().getPhoneService().storeData();

    }
}