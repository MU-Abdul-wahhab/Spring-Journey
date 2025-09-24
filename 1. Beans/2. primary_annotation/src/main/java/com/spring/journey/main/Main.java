package com.spring.journey.main;

import com.spring.journey.beans.Phone;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);
        // This won't throw NoUniqueBeanDefinitionException because we have added
        // @Primary annotation so spring container returns the primary object
        Phone phone = context.getBean(Phone.class);
        System.out.println("Getting Primary Phone Brand From Spring Context " + phone.getBrand());
        System.out.println("Getting Primary Phone Model From Spring Context " + phone.getModel());

        // If a bean has multiple primary annotation the spring throws NoUniqueBeanDefinitionException
    }
}