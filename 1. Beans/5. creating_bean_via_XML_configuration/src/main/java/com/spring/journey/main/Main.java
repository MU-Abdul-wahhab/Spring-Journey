package com.spring.journey.main;

import com.spring.journey.beans.Car;
import com.spring.journey.beans.Laptop;
import com.spring.journey.beans.Phone;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("beans.xml");

        Car honda = context.getBean("honda", Car.class);
        System.out.println("Getting Car Brand From Spring IoC Container via XML " + honda.getBrand());
        System.out.println("Getting Car Model From Spring IoC Container via XML " + honda.getModel());

        Car toyota = context.getBean("toyota", Car.class);
        System.out.println("Getting Car Brand From Spring IoC Container via XML " + toyota.getBrand());
        System.out.println("Getting Car Model From Spring IoC Container via XML " + toyota.getModel());

        Laptop hp = context.getBean("hp", Laptop.class);
        System.out.println("Getting Laptop Brand From Spring IoC Container via XML " + hp.getBrand());
        System.out.println("Getting Laptop Model From Spring IoC Container via XML " + hp.getModel());

        Laptop asus = context.getBean("asus", Laptop.class);
        System.out.println("Getting Laptop Brand From Spring IoC Container via XML " + asus.getBrand());
        System.out.println("Getting Laptop Model From Spring IoC Container via XML " + asus.getModel());

        Phone apple = context.getBean("apple", Phone.class);
        System.out.println("Getting Phone Brand From Spring IoC Container via XML " + apple.getBrand());
        System.out.println("Getting Phone Model From Spring IoC Container via XML " + apple.getModel());

        Phone samsung = context.getBean("samsung", Phone.class);
        System.out.println("Getting Phone Brand From Spring IoC Container via XML " + samsung.getBrand());
        System.out.println("Getting Phone Model From Spring IoC Container via XML " + samsung.getModel());

    }
}