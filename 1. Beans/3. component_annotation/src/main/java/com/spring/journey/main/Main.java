package com.spring.journey.main;

import com.spring.journey.beans.Car;
import com.spring.journey.beans.Laptop;
import com.spring.journey.beans.Phone;
import com.spring.journey.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        Car car = context.getBean("honda",Car.class);
        car.startCar();

        Laptop laptop = context.getBean(Laptop.class);
        laptop.turnOn();

        Phone phone = context.getBean(Phone.class);
        phone.turnOn();

        context.close();

    }
}