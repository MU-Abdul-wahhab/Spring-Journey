package com.spring.journey.main;

import com.spring.journey.beans.Car;
import com.spring.journey.beans.Laptop;
import com.spring.journey.beans.Phone;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    // Creating Bean Using Bean annotation
    public static void main(String[] args) {
        // 1. Retrieving the object from  Context
        var context = new AnnotationConfigApplicationContext(Config.class);
        Phone phone = context.getBean(Phone.class);
        System.out.println("From Spring  Context Getting Phone Brand " + phone.getBrand());
        System.out.println("From Spring Context Getting Phone Model " + phone.getModel());

        // 2. This will Throw NoUniqueBeanDefinitionException
        // Because in the config has two methods which returns Laptop type object
        // Spring Context confused which one to get. Solution number 1 is we can
        // get it by method name
        Laptop laptop = context.getBean("asus" ,Laptop.class);
        System.out.println("From Spring  Context Getting Laptop Brand " + laptop.getBrand());
        System.out.println("From Spring Context Getting Laptop Model " + laptop.getModel());

        // Another solution is to give a unique value inside bean annotation - @Bean(value = "toyota")
        Car car = context.getBean("toyota" ,Car.class);
        System.out.println("From Spring Context Getting Car Brand " + car.getBrand());
        System.out.println("From Spring Context Getting Car Brand " + car.getModel());
    }
}